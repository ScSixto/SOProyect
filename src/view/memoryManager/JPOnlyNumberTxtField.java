package view.memoryManager;

public class JPOnlyNumberTxtField extends JPTxtFieldPanel{

    private static final long serialVersionUID = 1L;

    private static final String TOO_BIG_VALUE_MESSAGE = "Valor demasiado grande";
    
    public static final boolean DOUBLE_NUMBER = true;
    public static final boolean INTEGER_NUMBER = false;

    private double maxValue;
    private boolean doubleNumber;

    public JPOnlyNumberTxtField(String title, String initialValue, double maxValue, boolean doubleNumber) {
        super(title, initialValue);
        this.maxValue = maxValue;
        this.doubleNumber = doubleNumber;
	}

    public boolean validateState(){
        boolean isGeneralState = super.validateState();
        String txt = txtField.getText();
        if(!isGeneralState){
            if(isNumeric(txt)){
                if(Double.parseDouble(txt.replace(UtilView.EMPTY_STRING+(char)44, UtilView.EMPTY_STRING+(char)46)) <= maxValue){
                    showGoodState();
                }else{
                    showWrongState(TOO_BIG_VALUE_MESSAGE);
                }
            }else{
                showWrongState(JPTxtFieldPanel.WRONG_TEXT_MESSAGE);
            }
        }
        return isGeneralState;
    }

    private boolean isNumeric(String txt){
        boolean isNumeric = true;
        if(txt.charAt(0) != 44 && txt.charAt(0) != 46 && hasUniqueDecimalSeparator(txt)){
            for (int i = 0; i < txt.length(); i++){
                if((txt.charAt(i) != 46 && txt.charAt(i) != 44) && (txt.charAt(i) < 48 || txt.charAt(i) > 57)){
                    isNumeric = false;
                    break;
                }
            }
        }else{
            isNumeric = false;
        }
        return isNumeric;
    }

	private boolean hasUniqueDecimalSeparator(String txt) {
        boolean hasUniqueDecimalSeparator = true;
        int count = 0;
        for (int i = 0; i < txt.length(); i++){
            if(doubleNumber){
                if(txt.charAt(i) == 44 || txt.charAt(i) == 46){
                    if(++count > 1){
                        hasUniqueDecimalSeparator = false;
                        break;
                    }
                }
            }else if(txt.charAt(i) == 44 || txt.charAt(i) == 46){
                hasUniqueDecimalSeparator = false;
                break;
            }
        }
        return hasUniqueDecimalSeparator;
    }
}