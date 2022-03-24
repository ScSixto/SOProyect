package view.memoryManager;

public class JPOnlyWordTxtField extends JPTxtFieldPanel{

    private static final long serialVersionUID = 1L;
    
    public JPOnlyWordTxtField(String title, String initialValue) {
        super(title, initialValue);
	}

    public boolean validateState(){
        boolean isGeneralState = super.validateState();
        String txt = txtField.getText();
        if(!isGeneralState){
            if(isWord(txt)){
                showGoodState();
            }else{
                showWrongState(JPTxtFieldPanel.WRONG_TEXT_MESSAGE);
            }
        }
        return isGeneralState;
    }

    private boolean isWord(String txt){
        boolean isWord = true;
            for (int i = 0; i < txt.length(); i++){
                if((txt.charAt(i) < 65 || txt.charAt(i) > 90) && (txt.charAt(i) < 97 || txt.charAt(i) > 122) && !isTilde(txt.charAt(i)) && txt.charAt(i) != 32){
                    isWord = false;
                    break;
                }
            }
        return isWord;
    }

	private boolean isTilde(char charAt) {
        return charAt == 193 || charAt == 201 || charAt == 205 || charAt == 209 || charAt == 211 || charAt == 218
                || charAt == 220 || charAt == 224 || charAt == 233 || charAt == 237 || charAt == 241 || charAt == 243
                || charAt == 250 || charAt == 252;
    }
}