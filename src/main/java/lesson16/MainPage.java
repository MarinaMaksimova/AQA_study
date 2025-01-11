package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by. Перевести ранее написанный тест на использование
паттерна PageObject и добавить следующие проверки:
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в
незаполненных полях для ввода реквизитов карты, наличие иконок платежных систем.*/

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    final String helpURL = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey";

    // Локаторы
    private final By onlinePaymentBlockConnectionPhone = By.xpath("//*[@id='connection-phone']");
    private final By onlinePaymentBlockConnectionSum = By.xpath("//*[@id='connection-sum']");
    private final By onlinePaymentBlockConnectionEmail = By.xpath("//*[@id='connection-email']");
    private final By onlinePaymentBlockInternetPhone = By.xpath("//*[@id='internet-phone']");
    private final By onlinePaymentBlockInternetSum = By.xpath("//*[@id='internet-sum']");
    private final By onlinePaymentBlockInternetEmail = By.xpath("//*[@id='internet-email']");
    private final By onlinePaymentBlockInstalmentScore = By.xpath("//*[@id='score-instalment']");
    private final By onlinePaymentBlockInstalmentSum = By.xpath("//*[@id='instalment-sum']");
    private final By onlinePaymentBlockInstalmentEmail = By.xpath("//*[@id='instalment-email']");
    private final By onlinePaymentBlockArrearsScore = By.xpath("//*[@id='score-arrears']");
    private final By onlinePaymentBlockArrearsSum = By.xpath("//*[@id='arrears-sum']");
    private final By onlinePaymentBlockArrearsEmail = By.xpath("//*[@id='arrears-email']");
    private final By onlinePaymentBlockContinueButton = By.xpath("//*[@id='pay-connection']/button");
    private final By cookieCancel = By.xpath("//button[@class='btn btn_gray cookie__cancel']");
    private final By onlinePaymentBlockTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By onlinePaymentBlockFAQ = By.xpath("//div[@class='pay__wrapper']/a");
    private final By onlinePaymentCreditCardForm = By.xpath("//div[@class='app-wrapper__content']");
    private final By creditCardFormCost = By.xpath("//div[@class='pay-description__cost']/span[1]");
    private final By creditCardFormPayButton = By.xpath("//div[@class='card-page__card']/button");
    private final By creditCardFormPhone = By.xpath("//div[@class='pay-description__text']/span");
    private final By creditCardFormCardNumber = By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']");
    private final By creditCardFormDate = By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']");
    private final By creditCardFormCardHolder = By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']");
    private final By creditCardFormCVC = By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']");
    private final By creditCardFormIcons = By.xpath("//div[@class='cards-brands ng-tns-c46-1']");
    private final By paymentIcons = By.className("pay__partners");
    private final By paymentIframe = By.className("bepaid-iframe");

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Отклонение куки
    public void cookieCancel() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));                  // ожидание открытия
        wait.until(ExpectedConditions.elementToBeClickable(cookieCancel)).click(); // отклонить куки
    }

    // Получить заголовок
    public String getPaymentBlockTitle() {
        return driver.findElement(onlinePaymentBlockTitle).getText().replaceAll("\n", " ");
    }

    // Получить creditCardFormCost
    public String getCost() {
        return driver.findElement(creditCardFormCost).getText();
    }

    // Получить creditCardFormPayButton
    public String getPayButton() {
        return driver.findElement(creditCardFormPayButton).getText();
    }

    // Получить creditCardFormPhone
    public String getPhone() {
        return driver.findElement(creditCardFormPhone).getText();
    }

    // Получить creditCardFormCardNumber
    public String getCardNumber() {
        return driver.findElement(creditCardFormCardNumber).getText();
    }

    // Получить creditCardFormDate
    public String getDate() {
        return driver.findElement(creditCardFormDate).getText();
    }

    // Получить creditCardFormCardHolder
    public String getCardHolder() {
        return driver.findElement(creditCardFormCardHolder).getText();
    }

    // Получить creditCardFormCVC
    public String getCVC() {
        return driver.findElement(creditCardFormCVC).getText();
    }

    // Получить плейсхолдер ConnectionPhone
    public String getConnectionPhone() {
        return driver.findElement(onlinePaymentBlockConnectionPhone).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ConnectionSum
    public String getConnectionSum() {
        return driver.findElement(onlinePaymentBlockConnectionSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ConnectionEmail
    public String getConnectionEmail() {
        return driver.findElement(onlinePaymentBlockConnectionEmail).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InternetPhone
    public String getInternetPhone() {
        return driver.findElement(onlinePaymentBlockInternetPhone).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InternetSum
    public String getInternetSum() {
        return driver.findElement(onlinePaymentBlockInternetSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InternetEmail
    public String getInternetEmail() {
        return driver.findElement(onlinePaymentBlockInternetEmail).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InstalmentScore
    public String getInstalmentScore() {
        return driver.findElement(onlinePaymentBlockInstalmentScore).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InstalmentSum
    public String getInstalmentSum() {
        return driver.findElement(onlinePaymentBlockInstalmentSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InstalmentEmail
    public String getInstalmentEmail() {
        return driver.findElement(onlinePaymentBlockInstalmentEmail).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ArrearsScore
    public String getArrearsScore() {
        return driver.findElement(onlinePaymentBlockArrearsScore).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ArrearsSum
    public String getArrearsSum() {
        return driver.findElement(onlinePaymentBlockArrearsSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ArrearsEmail
    public String getArrearsEmail() {
        return driver.findElement(onlinePaymentBlockArrearsEmail).getDomProperty("placeholder");
    }

    // Отобрализся ли фрейм
    public boolean isPaymentCreditCardFormDisplayed(){
        formToBeClickable();
        return driver.findElement(onlinePaymentCreditCardForm).isDisplayed();
    }

    // Получить логотипы
    public List<String> getPaymentLogos() {
        List<WebElement> elements = driver.findElements(paymentIcons);
        List<String> paymentLogos = new ArrayList<>();

        for (WebElement element : elements) {
            List<WebElement> images = element.findElements(By.tagName("img"));
            for (WebElement img : images) {
                String altText = img.getDomProperty("alt");
                if (altText != null && !altText.isEmpty()) {
                    paymentLogos.add(altText);
                }
            }
        }
        return paymentLogos;
    }

    // Получить логотипы фрейма
    public List<String>  getPaymentLogosOnPaymentFrame() {
        List<WebElement> elements = driver.findElements(creditCardFormIcons);
        List<String> paymentLogos = new ArrayList<>();

        for(WebElement element : elements){
            List<WebElement> images = element.findElements(By.tagName("img"));
            for(WebElement img : images) {
                String textSrc = img.getDomProperty("src");
                if (textSrc != null && !textSrc.isEmpty()) {
                    paymentLogos.add(textSrc);
                }
            }
        }
        return paymentLogos;
    }

    // клик на ссылку и ожидание
    public boolean clickPaymentBlockFAQ() {
        driver.findElement(onlinePaymentBlockFAQ).click();
        return wait.until(ExpectedConditions.urlContains(helpURL));
    }

    // Ожидание фрейма
    public void formToBeClickable(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
        wait.until(ExpectedConditions.elementToBeClickable(onlinePaymentCreditCardForm));
    }

    // Заполнение формы
    public void completeOnlinePayment(String phoneNumber, String amount) {
        driver.findElement(onlinePaymentBlockConnectionPhone).sendKeys(phoneNumber);
        driver.findElement(onlinePaymentBlockConnectionSum).sendKeys(amount);
        driver.findElement(onlinePaymentBlockContinueButton).click();
    }
}