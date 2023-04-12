package com.yedam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.categorys.CategorysDAO;
import com.yedam.comment.CommentDAO;
import com.yedam.member.MemberService;

public class BoardService {
	Scanner sc = new Scanner(System.in);
	public static int boardCategory = 0;
	public void clearConsole() {
		for(int i=0;i<80;i++) {
			System.out.println();
		}
	}
	public void boardList(int categoryNo) {
		boardCategory = categoryNo;
		int index = 1;
		while (true) {
			String category = CategorysDAO.getInstance().getCategoryName(categoryNo);
			System.out.println("<" + category + " 게시판 >");
			List<String> titleList = BoardDAO.getInstance().getBoardTitleList(categoryNo);
			
			int indexCnt = titleList.size() / 10 + 1;
			if (index == indexCnt) {
				for (int i = 1; i <= titleList.size() % 10; i++) {
					System.out.println(i + ")  " + titleList.get(i  + (index-1)*10 - 1));
				}
			} else {
				for (int i = 1; i <= 10; i++) {
					System.out.println(i + ")  " + titleList.get(i + (index-1)*10 - 1));
				}
			}
			System.out.print("<");
			for (int i = 1; i <= indexCnt; i++) {
				System.out.print(" "+i+" ");
			}
			System.out.println(">");

			System.out.println("다른 번호의 목록 | 0. 현재 목록의 게시물 보기 or 종료");
			int tmp = Integer.parseInt(sc.nextLine());
			if(tmp != 0) {
				if(tmp >indexCnt) {
					System.out.println(" <!> 범위를 벗어났습니다.");
					continue;
				}
				index = tmp;
				continue;
			}
			if (MemberService.memberInfo == null) {
				System.out.println("게시물 번호 | 0. 종료");
			} else {
				System.out.println("게시물 번호 | 99.글쓰기 | 0. 종료");
			}
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 0) {
				boardCategory = 0;
				break;
			} else if (menu == 99) {
				addBoard();
			} else {
				detailBoard(titleList.get(menu+(index-1)*10 - 1));
			}
		}
	}

	public void detailBoard(String title) {
		while (true) {
			List<Board> board = BoardDAO.getInstance().getBoardInfo(title);
			System.out.println("<게시물>");
			System.out.println("제목 :" + board.get(0).getBoardTitle());
			if (boardCategory == 5) {
				System.out.print("ID : 익명");
			} else {
				System.out.print("ID : " + board.get(0).getMemberId());
			}
			System.out.println("\t날짜 : " + board.get(0).getBoardDate());
			System.out.println("본문\n" + board.get(0).getBoardContent());
			System.out.println("<댓글>");
			if (board.get(0).getCommentContent() != null) {
				for (int i = 0; i < board.size(); i++) {
					System.out.println("---------------------------------");
					if (boardCategory == 5) {
						System.out.print("\tID : 익명" + (i + 1));
					} else {
						System.out.print("\tID : " + board.get(i).getCommentId());
					}
					System.out.println("\t날짜 : " + board.get(i).getCommentDate());
					System.out.println("\t" + board.get(i).getCommentContent());
				}
			} else {
				System.out.println("\t첫 댓글을 작성해 주세요");
			}

			if (MemberService.memberInfo == null) {
				System.out.println(" 0. 뒤로가기");
				int select = Integer.parseInt(sc.nextLine());
				if (select == 0) {
					break;
				}
			} else if (MemberService.memberInfo.getId().equals(board.get(0).getMemberId())) {
				System.out.println("1. 수정 | 2. 삭제 | 3. 댓글 작성 | 0. 뒤로가기");
				int select = Integer.parseInt(sc.nextLine());
				int result = 0;
				if (select == 1) {
					System.out.println("수정할 인덱스 > (1.제목,2.내용)");
					int change = Integer.parseInt(sc.nextLine());
					String changeIndex = null;
					if (change == 1) {
						changeIndex = "board_title";
					} else if (change == 2) {
						changeIndex = "board_content";
					}
					System.out.println("수정 내용 >");
					String changeContent = sc.nextLine();
					result = BoardDAO.getInstance().updateBoard(changeIndex, changeContent, board.get(0).getBoardNo());
					if (result > 0) {
						System.out.println("수정 완료");
					} else {
						System.out.println("수정 실패");
					}
				} else if (select == 2) {
					result = BoardDAO.getInstance().deleteBoard(board.get(0).getBoardNo());
					if (result > 0) {
						System.out.println("삭제 완료");
						break;
					} else {
						System.out.println("삭제 실패");
					}
				} else if (select == 3) {
					System.out.println("댓글 내용 >");
					String commentContent = sc.nextLine();
					CommentDAO.getInstance().addComment(commentContent, board.get(0).getBoardNo());
				} else if (select == 0) {
					break;
				}
			} else {
				System.out.println("1. 댓글 작성 | 0. 뒤로가기");
				int select = Integer.parseInt(sc.nextLine());
				if (select == 1) {
					System.out.println("댓글 내용 >");
					String commentContent = sc.nextLine();
					CommentDAO.getInstance().addComment(commentContent, board.get(0).getBoardNo());
				} else if (select == 0) {
					break;
				}
			}
		}
	}

	public void addBoard() {
		System.out.println("제목을 입력하세요 > ");
		String title = sc.nextLine();
		System.out.println("내용을 입력하세요 > ");
		String content = sc.nextLine();

		int result = BoardDAO.getInstance().addBoard(title, content);
		if (result > 0) {
			System.out.println("작성이 완료 되었습니다.");
		} else {
			System.out.println("작성에 실패했습니다.");
		}
	}
}
