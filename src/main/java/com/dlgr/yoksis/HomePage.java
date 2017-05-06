package com.dlgr.yoksis;

import com.dlgr.yoksis.dto.AnnounceDTO;
import com.dlgr.yoksis.dto.UniversityDTO;
import com.dlgr.yoksis.service.ProjectService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdlkrmdlgr
 * E-mail:abdulkerimdulger@comu.edu.tr
 * Created Date: 6.10.2016
 */
public class HomePage {

    private static List<String> sessionIdList = new ArrayList<String>();
    private static String baseUrl = "https://yoksis.yok.gov.tr/ilansayfa/";
    private static String pageIndicator;
    private static WebDriver driver;
    private static ProjectService projectService;


    public static void main(String[] args) throws InterruptedException, IOException {

        projectService = new ProjectService();

        System.setProperty("webdriver.gecko.driver", "C:/java/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
//        WebElement searchBox = driver.findElement(By.className("z-textbox"));
//        searchBox.sendKeys("bilgisayar");
//        Thread.sleep(2000);
//        WebElement searchButton = driver.findElement(By.className("z-button-os"));
//        searchButton.click();
//
//        getPageAnnounceUrl();
//        Thread.sleep(2000);
//
//        for (String sessionId : sessionIdList) {
//            System.out.println(sessionId + " okunuyor");
//            getAnnounce(sessionId);
//            Thread.sleep(1000);
//        }


//        ÜNİVERSİTELERİ GETİRİR
        getUniversity();


//        try {
//
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/announcedb";
//
//            String kullaniciad = "sa";
//            String sifre = "6476";
//
//            Connection con = null;
//            Statement st;
//            st = null;
//            ResultSet rs = null;
//
//            con = DriverManager.getConnection(url, kullaniciad, sifre);
//            st = con.createStatement();
//
//            System.out.println("Baglandi");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }


    }

    private static AnnounceDTO getAnnounce(String sessionId) {

        System.out.println(sessionId + " ilanının detaylarına bakıyoruz.");
        driver.get(baseUrl + "?sessionid=" + sessionId);
        String spIndic = driver.findElement(By.className("z-window-embedded")).getAttribute("id");
        pageIndicator = spIndic.substring(0, spIndic.length() - 1);

        /**
         *
         x0 		ilanNo
         11 		ilanın çıkarılacağı yer
         41 		pozisyon
         81 		ales
         c1 		kadro sayısı
         e1 		yds
         h1 		kadro derecesi
         j1-real 	duyuru başlangıç tarihi
         m1-real 	son başvuru tarihi
         o1-real 	sonuç açıklama tarihi
         r1-real 	ön değerlendirme tarihi
         t1-real 	sınav giriş tarihi
         12 		başvuru tipi
         82 		başvuru yeri
         b2		sonuç açıklanacağı yer
         f2 		özel şartlar
         j2-rows 	genel şartlar * rowları çekmen gerek burda.
         o2-rows 	ünvan şartları * rowları çekmen gerek burda
         t2 	istenen belgeler *
         w2 		muafiyet
         */
        AnnounceDTO announceDTO = new AnnounceDTO();
        announceDTO.setNumber(getFieldText("x0"));
        announceDTO.setLocation(getFieldText("11"));
        announceDTO.setTitle(getFieldText("41"));
        announceDTO.setCount(getFieldValue("c1"));
        announceDTO.setAlesPoint(getFieldValue("81"));
        announceDTO.setYdsPoint(getFieldValue("e1"));
        announceDTO.setDegree(getFieldValue("h1"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try {
            announceDTO.setApplicationStartDate(sdf.parse(getFieldValue("j1-real")));
            announceDTO.setApplicationEndDate(sdf.parse(getFieldValue("m1-real")));
            announceDTO.setScoreAnnouncedDate(sdf.parse(getFieldValue("o1-real")));
            announceDTO.setPreEvaluationDate(sdf.parse(getFieldValue("r1-real")));
            announceDTO.setExamDate(sdf.parse(getFieldValue("t1-real")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        announceDTO.setApplicationType(getFieldValue("12"));
        announceDTO.setApplicationLocation(getFieldValue("82"));
        announceDTO.setAnnouncedLocation(getFieldValue("b2"));
        announceDTO.setSpecialConditions(getFieldValue("f2"));

        announceDTO.setSpecialConditions(getFieldText("f2"));

        WebElement generalContitionTable = driver.findElement(By.id(pageIndicator + "j2-rows"));
        String generalCondition = getCondition(generalContitionTable);
        announceDTO.setGeneralConditions(generalCondition);

        WebElement titleContitionTable = driver.findElement(By.id(pageIndicator + "o2-rows"));
        String titleCondition = getCondition(titleContitionTable);
        announceDTO.setTitleConditions(titleCondition);

        announceDTO.setRequiredDocument(getFieldText("t2"));
        announceDTO.setExemption(getFieldText("w2"));
        return announceDTO;
    }

    private static String getCondition(WebElement contitionElement) {
        List<WebElement> contitionElementList = contitionElement.findElements(By.className("z-listcell-cnt"));

        String condition = "";
        for (WebElement webElement : contitionElementList) {
            condition += webElement.getText() + "\n";
        }
        return condition;
    }

    private static String getFieldValue(String indicator) {
        return driver.findElement(By.id(pageIndicator + indicator)).getAttribute("value");
    }

    private static String getFieldText(String indicator) {
        return driver.findElement(By.id(pageIndicator + indicator)).getText();
    }

//    private static void getPageCount() {
//
//        String pageInfo = driver.findElement(By.className("z-paging-info")).getText();
//        int startIndex = pageInfo.indexOf("/") + 2;
//        int endIndex = pageInfo.indexOf("]") - 1;
//        String totalRow = pageInfo.substring(startIndex, endIndex);
//
//        totalPage = (int) Math.ceil(Integer.parseInt(totalRow) / rowPerPage);
//
//    }

    private static void getPageAnnounceUrl() throws InterruptedException {

        Thread.sleep(2000);
        WebElement contentDiv = driver.findElement(By.className("z-listbox-body"));
        List<WebElement> listCurrentPagesRow = contentDiv.findElements(By.className("z-toolbarbutton-cnt"));

        for (WebElement webElement : listCurrentPagesRow) {

            String url = webElement.getText();
            int idStart = url.indexOf("=") + 1;
            sessionIdList.add(url.substring(idStart, url.length()));

        }

        if (hasNext()) {
            getNextButton().click();
            getPageAnnounceUrl();
        }

    }

    private static boolean hasNext() {

        List<WebElement> webElementList = driver.findElements(By.className("z-paging-btn"));
        return !webElementList.get(2).getAttribute("class").contains("z-paging-btn-disd");

    }

    public static void getUniversity() throws InterruptedException {

        //sayfadaki tüm üniversitelerin web elementleri gelir.
        List<WebElement> webElementsName = driver.findElements(By.className("z-listitem"));
        //sayfadaki üniversite isimleri için tablonun satır elemenlerini toplar
        for (WebElement webElement : webElementsName) {
            String name = webElement.findElement(By.className("z-label")).getText();
            String logo = webElement.findElement(By.tagName("img")).getAttribute("src");
//            universityList.add(new com.dlgr.yoksis.model.University(logo, name));

//            Services projectService = new Services();

//TODO: save işlemi var
            UniversityDTO universityDTO = projectService.saveUniversity(new UniversityDTO(logo, name));
//            UniversityDTO universityDTO = new UniversityDTO();

            webElement.click();
            getPageAnnounceUrl();

            for (String sessionId : sessionIdList) {

                AnnounceDTO announceDTO = getAnnounce(sessionId);
                announceDTO.setUniversity(universityDTO);
                //TODO: save işlemi var.
                //projectService.saveAnnounce(announceDTO);

                Thread.sleep(500);

            }

            Thread.sleep(500);
        }

        //sayfaları dolaşır
        if (hasNext()) {
            getNextButton().click();
            Thread.sleep(2000);
            getUniversity();
        }
    }

    public static WebElement getNextButton() {
        return driver.findElement(By.className("z-paging-next"));

    }
}
