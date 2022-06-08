package pages;

public enum CssAttributes {
    HOVER_COLOR("rgba(255, 103, 32, 1)");

    public String attributeValue;

    CssAttributes(String attributeValue){
        this.attributeValue = attributeValue;
    }
    String getAttributeValue(){return attributeValue;}
}
