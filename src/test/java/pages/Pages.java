package pages;

public enum Pages {

    PRODUCTS("Продукты","/products/"),
    SERVICES("Услуги","/support/"),
    CLIENTS("Клиенты","/clients/"),
    PARTNERS("Партнеры","/partners/"),
    ABOUT_US("О нас","/company/"),
    PRESS_CENTER("Пресс-центр","/events/news/"),
    CAREER("Карьера","/career/");

    public String menuName;
    public String pageUrl;

    Pages(String menuName, String pageUrl){
        this.menuName = menuName;
        this.pageUrl = pageUrl;
    }
}
