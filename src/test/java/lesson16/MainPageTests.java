package lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by. Перевести ранее написанный тест на использование
паттерна PageObject и добавить следующие проверки:
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в
незаполненных полях для ввода реквизитов карты, наличие иконок платежных систем.*/

public class MainPageTests {

    private MainPage mainPage;
    private WebDriver driver;
    final String imgURL = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // открыть окно на весь экран
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver); // Инициализация объекта mainPage
        mainPage.cookieCancel();  // отклонить куки
    }

    @Test           // Проверить название указанного блока
    @DisplayName("Проверка названия указанного блока")
    public void verifyBlockName() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getPaymentBlockTitle());
    }

    @Test           // Проверить наличие логотипов платежных систем
    @DisplayName("Проверка наличия логотипов платежных систем")
    public void verifyPaymentSystemsLogos() {
        List<String> expectedTexts = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        List<String> actualTexts = mainPage.getPaymentLogos();
        assertEquals(expectedTexts, actualTexts);
    }

    @Test           // Проверить работу ссылки «Подробнее о сервисе»
    @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
    public void verifyServiceLink() {
        assertTrue(mainPage.clickPaymentBlockFAQ());
    }

    @Test           // Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
    @DisplayName("Проверка работы кнопки «Продолжить»")
    public void verifyContinue() {
        mainPage.completeOnlinePayment("297777777", "12");
        assertTrue(mainPage.isPaymentCreditCardFormDisplayed());
    }

    @Test           // Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
    @DisplayName("Проверка надписей в незаполненных полях")
    public void verifyDefaultText() {
        //Услуги связи
        assertEquals("Номер телефона",  mainPage.getConnectionPhone());
        assertEquals("Сумма",  mainPage.getConnectionSum());
        assertEquals("E-mail для отправки чека",  mainPage.getConnectionEmail());
        //Домашний интернет
        assertEquals("Номер абонента",  mainPage.getInternetPhone());
        assertEquals("Сумма",  mainPage.getInternetSum());
        assertEquals("E-mail для отправки чека",  mainPage.getInternetEmail());
        //Рассрочка
        assertEquals("Номер счета на 44",  mainPage.getInstalmentScore());
        assertEquals("Сумма",  mainPage.getInstalmentSum());
        assertEquals("E-mail для отправки чека",  mainPage.getInstalmentEmail());
        //Задолженность
        assertEquals("Номер счета на 2073",  mainPage.getArrearsScore());
        assertEquals("Сумма",  mainPage.getArrearsSum());
        assertEquals("E-mail для отправки чека",  mainPage.getArrearsEmail());
    }

    @Test
    @DisplayName("Проверка корректности отображения суммы, номера телефона, надписей в полях реквизитов и иконок на фрейме")
    //Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
    // в появившемся окне проверить корректность отображения суммы (в том числе на кнопке), номера телефона, а также надписей в
    // незаполненных полях для ввода реквизитов карты, наличие иконок платежных систем.
    public void verifyContinuePopUp() {
        mainPage.completeOnlinePayment("297777777", "12");
        mainPage.formToBeClickable();
        assertEquals("12.00 BYN", mainPage.getCost());
        assertEquals("Оплатить 12.00 BYN", mainPage.getPayButton());
        assertEquals("Оплата: Услуги связи Номер:375297777777", mainPage.getPhone());
        assertEquals("Номер карты", mainPage.getCardNumber());
        assertEquals("Срок действия", mainPage.getDate());
        assertEquals("Имя держателя (как на карте)", mainPage.getCardHolder());
        assertEquals("CVC", mainPage.getCVC());
        // проверка иконок платежных систем
        List<String> expectedTexts = List.of(imgURL + "visa-system.svg", imgURL + "mastercard-system.svg", imgURL + "belkart-system.svg", imgURL + "maestro-system.svg", imgURL + "mir-system-ru.svg");
        List<String> actualTexts = mainPage.getPaymentLogosOnPaymentFrame();
        assertEquals(expectedTexts, actualTexts);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем веб-драйвер после выполнения теста
        }
    }
}