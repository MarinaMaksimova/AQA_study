package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by. Перевести ранее написанный тест на использование
паттерна PageObject и добавить следующие проверки:
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в
незаполненных полях для ввода реквизитов карты, наличие иконок платежных систем.*/

public class MainPage {

    private WebDriver driver;

    By onlinePaymentBlockConnectionPhone = By.xpath("//*[@id=\"connection-phone\"]");
    By onlinePaymentBlockConnectionSum = By.xpath("//*[@id=\"connection-sum\"]");
    By onlinePaymentBlockConnectionEmail = By.xpath("//*[@id=\"connection-email\"]");
    By onlinePaymentBlockInternetPhone = By.xpath("//*[@id=\"internet-phone\"]");
    By onlinePaymentBlockInternetSum = By.xpath("//*[@id=\"internet-sum\"]");
    By onlinePaymentBlockInternetEmail = By.xpath("//*[@id=\"internet-email\"]");
    By onlinePaymentBlockInstalmentScore = By.xpath("//*[@id=\"score-instalment\"]");
    By onlinePaymentBlockInstalmentSum = By.xpath("//*[@id=\"instalment-sum\"]");
    By onlinePaymentBlockInstalmentEmail = By.xpath("//*[@id=\"instalment-email\"]");
    By onlinePaymentBlockArrearsScore = By.xpath("//*[@id=\"score-arrears\"]");
    By onlinePaymentBlockArrearsSum = By.xpath("//*[@id=\"arrears-sum\"]");
    By onlinePaymentBlockArrearsEmail = By.xpath("//*[@id=\"arrears-email\"]");
    By onlinePaymentBlockContinueButton = By.xpath("//*[@id=\"pay-connection\"]/button");

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    // Заполнение формы
    public void completeOnlinePayment(String phoneNumber, String amount) {
        driver.findElement(onlinePaymentBlockConnectionPhone).sendKeys(phoneNumber);
        driver.findElement(onlinePaymentBlockConnectionSum).sendKeys(amount);
        driver.findElement(onlinePaymentBlockContinueButton).click();
    }

    // Услуги связи
    public void verifyConnectionDefault() {
        assertEquals("Номер телефона", driver.findElement(onlinePaymentBlockConnectionPhone).getDomProperty("placeholder"));
        assertEquals("Сумма", driver.findElement(onlinePaymentBlockConnectionSum).getDomProperty("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(onlinePaymentBlockConnectionEmail).getDomProperty("placeholder"));
    }

    // Домашний интернет
    public void verifyInternetDefault() {
        assertEquals("Номер абонента", driver.findElement(onlinePaymentBlockInternetPhone).getDomProperty("placeholder"));
        assertEquals("Сумма", driver.findElement(onlinePaymentBlockInternetSum).getDomProperty("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(onlinePaymentBlockInternetEmail).getDomProperty("placeholder"));
    }

    // Рассрочка
    public void verifyInstalmentDefault() {
        assertEquals("Номер счета на 44", driver.findElement(onlinePaymentBlockInstalmentScore).getDomProperty("placeholder"));
        assertEquals("Сумма", driver.findElement(onlinePaymentBlockInstalmentSum).getDomProperty("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(onlinePaymentBlockInstalmentEmail).getDomProperty("placeholder"));
    }

    // Задолженность
    public void verifyArrearsDefault() {
        assertEquals("Номер счета на 2073", driver.findElement(onlinePaymentBlockArrearsScore).getDomProperty("placeholder"));
        assertEquals("Сумма", driver.findElement(onlinePaymentBlockArrearsSum).getDomProperty("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(onlinePaymentBlockArrearsEmail).getDomProperty("placeholder"));
    }

}
