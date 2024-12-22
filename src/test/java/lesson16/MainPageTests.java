package lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by. Перевести ранее написанный тест на использование
паттерна PageObject и добавить следующие проверки:
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в
незаполненных полях для ввода реквизитов карты, наличие иконок платежных систем.*/

public class MainPageTests {

    private MainPage mainPage;
    private WebDriver driver;
    private WebDriverWait wait;

    By cookieCancel = By.xpath("//button[@class='btn btn_gray cookie__cancel']");
    By onlinePaymentBlockTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    By onlinePaymentBlockPaymentLogos = By.xpath("//div[@class='pay__partners']");
    By onlinePaymentBlockFAQ = By.xpath("//div[@class='pay__wrapper']/a");
    By onlinePaymentCreditCardForm = By.xpath("//div[@class='app-wrapper__content']");
    By creditCardFormCost = By.xpath("//div[@class='pay-description__cost']/span[1]");
    By creditCardFormPayButton = By.xpath("//div[@class='card-page__card']/button");
    By creditCardFormPhone = By.xpath("//div[@class='pay-description__text']/span");
    By creditCardFormPayIcons = By.xpath("//div[@class='icons-container ng-tns-c46-1']");
    By creditCardFormCardNumber = By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']");
    By creditCardFormDate = By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']");
    By creditCardFormCardHolder = By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']");
    By creditCardFormCVC = By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']");

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // открыть окно на весь экран
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver); // Инициализация объекта mainPage
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ожидание открытия
        wait.until(ExpectedConditions.elementToBeClickable(cookieCancel)).click();  // отклонить куки
    }

    @Test           // Проверить название указанного блока
    public void verifyBlockName() {
        assertEquals("Онлайн пополнение\nбез комиссии", driver.findElement(onlinePaymentBlockTitle).getText());
    }

    @Test           // Проверить наличие логотипов платежных систем
    public void verifyPaymentSystemsLogos() {
        assertTrue(driver.findElement(onlinePaymentBlockPaymentLogos).isDisplayed());
    }

    @Test           // Проверить работу ссылки «Подробнее о сервисе»
    public void verifyServiceLink() {
        driver.findElement(onlinePaymentBlockFAQ).click();
        assertTrue(wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey")));
        //assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    // Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
    public void verifyContinue() {
        mainPage.completeOnlinePayment("297777777", "12");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.elementToBeClickable(onlinePaymentCreditCardForm));
        assertTrue(driver.findElement(onlinePaymentCreditCardForm).isDisplayed());
    }

    @Test
    // Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
    public void verifyDefaultText() {
        mainPage.verifyConnectionDefault();      //Услуги связи
        mainPage.verifyInternetDefault();        //Домашний интернет
        mainPage.verifyInstalmentDefault();      //Рассрочка
        mainPage.verifyArrearsDefault();         //Задолженность
    }

    @Test
    //Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
    // в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в
    // незаполненных полях для ввода реквизитов карты, наличие иконок платежных систем.
    public void verifyContinuePopUp() {
        mainPage.completeOnlinePayment("297777777", "12");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.elementToBeClickable(onlinePaymentCreditCardForm));
        assertEquals("12.00 BYN", driver.findElement(creditCardFormCost).getText());
        assertEquals("Оплатить 12.00 BYN", driver.findElement(creditCardFormPayButton).getText());
        assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement(creditCardFormPhone).getText());
        assertTrue(driver.findElement(creditCardFormPayIcons).isDisplayed());
        assertEquals("Номер карты", driver.findElement(creditCardFormCardNumber).getText());
        assertEquals("Срок действия", driver.findElement(creditCardFormDate).getText());
        assertEquals("Имя держателя (как на карте)", driver.findElement(creditCardFormCardHolder).getText());
        assertEquals("CVC", driver.findElement(creditCardFormCVC).getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем веб-драйвер после выполнения теста
        }
    }
}
