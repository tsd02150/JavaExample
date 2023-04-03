package Question2;

import Question1.Keypad;

public class PortableNotebook implements Notebook,Tablet{
	public int mode;
	public String docProgram;
	public String internetBrowser;
	public String kindVideo;
	public String kindApp;
	public PortableNotebook(String docprogram,String internetBrowser,String kindVideo,String kindApp) {
		this.mode = Notebook.NOTEBOOK_MODE;
		this.docProgram = docprogram;
		this.internetBrowser = internetBrowser;
		this.kindVideo = kindVideo;
		this.kindApp = kindApp;
		System.out.println("NOTEBOOK_MODE");
	}
	@Override
	public void writeDocumentation() {
		System.out.println(this.docProgram+"을 통해 문서를 작성");
	}
	@Override
	public void searchInternet() {
		System.out.println(this.internetBrowser+"를 통해 인터넷을 검색");
	}
	@Override
	public void watchVideo() {
		System.out.println(this.kindVideo + "를 시청");
	}
	@Override
	public void useApp() {
		System.out.println(this.kindApp + "앱을 실행");
	}
	
	public void changeMode() {
		if(this.mode==Notebook.NOTEBOOK_MODE) {
			this.mode = Tablet.TABLET_MODE;
			System.out.println("TABLET_MODE");
		}else if(this.mode == Keypad.HARD_MODE) {
			this.mode = Tablet.TABLET_MODE;
			System.out.println("NOTEBOOK_MODE");
		}
	}
	
}
