package lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*Необходимо взять тест из практического задания в теме
“Selenium. Часть 2” и добавить Allure-репорт.*/

public class MainPage {

    private final WebDriver driver;
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
    @Step("Отклонение куки")
    public void cookieCancel() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));                  // ожидание открытия
        wait.until(ExpectedConditions.elementToBeClickable(cookieCancel)).click(); // отклонить куки
    }

    // Получить заголовок
    @Step("Получение заголовка")
    public String getPaymentBlockTitle() {
        return driver.findElement(onlinePaymentBlockTitle).getText().replaceAll("\n", " ");
    }

    // Получить creditCardFormCost
    @Step("Форма оплаты: получение стоимости оплаты")
    public String getCost() {
        return driver.findElement(creditCardFormCost).getText();
    }

    // Получить creditCardFormPayButton
    @Step("Форма оплаты: получение стоимости оплаты на кнопке")
    public String getPayButton() {
        return driver.findElement(creditCardFormPayButton).getText();
    }

    // Получить creditCardFormPhone
    @Step("Форма оплаты: получение номера телефона")
    public String getPhone() {
        return driver.findElement(creditCardFormPhone).getText();
    }

    // Получить creditCardFormCardNumber
    @Step("Форма оплаты: получение номера карты")
    public String getCardNumber() {
        return driver.findElement(creditCardFormCardNumber).getText();
    }

    // Получить creditCardFormDate
    @Step("Форма оплаты: получение срока действия карты")
    public String getDate() {
        return driver.findElement(creditCardFormDate).getText();
    }

    // Получить creditCardFormCardHolder
    @Step("Форма оплаты: получение имени держателя карты")
    public String getCardHolder() {
        return driver.findElement(creditCardFormCardHolder).getText();
    }

    // Получить creditCardFormCVC
    @Step("Форма оплаты: получение CVC")
    public String getCVC() {
        return driver.findElement(creditCardFormCVC).getText();
    }

    // Получить плейсхолдер ConnectionPhone
    @Step("Услуги связи: получение плейсхолдера \"Номер телефона\"")
    public String getConnectionPhone() {
        return driver.findElement(onlinePaymentBlockConnectionPhone).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ConnectionSum
    @Step("Услуги связи: получение плейсхолдера \"Сумма\"")
    public String getConnectionSum() {
        return driver.findElement(onlinePaymentBlockConnectionSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ConnectionEmail
    @Step("Услуги связи: получение плейсхолдера \"Email\"")
    public String getConnectionEmail() {
        return driver.findElement(onlinePaymentBlockConnectionEmail).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InternetPhone
    @Step("Домашний интернет: получение плейсхолдера \"Номер телефона\"")
    public String getInternetPhone() {
        return driver.findElement(onlinePaymentBlockInternetPhone).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InternetSum
    @Step("Домашний интернет: получение плейсхолдера \"Сумма\"")
    public String getInternetSum() {
        return driver.findElement(onlinePaymentBlockInternetSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InternetEmail
    @Step("Домашний интернет: получение плейсхолдера \"Email\"")
    public String getInternetEmail() {
        return driver.findElement(onlinePaymentBlockInternetEmail).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InstalmentScore
    @Step("Рассрочка: получение плейсхолдера \"Номер счета\"")
    public String getInstalmentScore() {
        return driver.findElement(onlinePaymentBlockInstalmentScore).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InstalmentSum
    @Step("Рассрочка: получение плейсхолдера \"Сумма\"")
    public String getInstalmentSum() {
        return driver.findElement(onlinePaymentBlockInstalmentSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер InstalmentEmail
    @Step("Рассрочка: получение плейсхолдера \"Email\"")
    public String getInstalmentEmail() {
        return driver.findElement(onlinePaymentBlockInstalmentEmail).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ArrearsScore
    @Step("Задолженность: получение плейсхолдера \"Номер счета\"")
    public String getArrearsScore() {
        return driver.findElement(onlinePaymentBlockArrearsScore).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ArrearsSum
    @Step("Задолженность: получение плейсхолдера \"Сумма\"")
    public String getArrearsSum() {
        return driver.findElement(onlinePaymentBlockArrearsSum).getDomProperty("placeholder");
    }

    // Получить плейсхолдер ArrearsEmail
    @Step("Задолженность: получение плейсхолдера \"Email\"")
    public String getArrearsEmail() {
        return driver.findElement(onlinePaymentBlockArrearsEmail).getDomProperty("placeholder");
    }

    // Отобразился ли фрейм
    @Step("Отображение фрейма")
    public boolean isPaymentCreditCardFormDisplayed(){
        formToBeClickable();
        return driver.findElement(onlinePaymentCreditCardForm).isDisplayed();
    }

    // Получить логотипы
    @Step("Получение логотипов")
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
    @Step("Получение логотипов фрейма")
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

    // Клик на ссылку и ожидание
    @Step("Клик на ссылку и ожидание")
    public boolean clickPaymentBlockFAQ() {
        driver.findElement(onlinePaymentBlockFAQ).click();
        return wait.until(ExpectedConditions.urlContains(helpURL));
    }

    // Ожидание фрейма
    @Step("Ожидание фрейма")
    public void formToBeClickable(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
        wait.until(ExpectedConditions.elementToBeClickable(onlinePaymentCreditCardForm));
    }

    // Заполнение формы
    @Step("Заполнение формы")
    public void completeOnlinePayment(String phoneNumber, String amount) {
        driver.findElement(onlinePaymentBlockConnectionPhone).sendKeys(phoneNumber);
        driver.findElement(onlinePaymentBlockConnectionSum).sendKeys(amount);
        driver.findElement(onlinePaymentBlockContinueButton).click();
    }
}