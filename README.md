# Тестирование UI сайта компании Naumen
[![naumen](https://user-images.githubusercontent.com/71780020/172861017-4db52962-4e9d-4a63-bf61-fed7e5bfbb52.png)](https://www.naumen.ru/)

### В проекте использованы :gear:
<img src="image/Java.svg" width="100"><img src="image/JUnit5.svg" width="100"><img src="image/Gradle.svg" width="100"><img src="image/Intelij_IDEA.svg" width="100"><img src="image/Selenide.svg" width="100"><img src="image/Selenoid.svg" width="100"><img src="image/GitHub.svg" width="100"><img src="image/Jenkins.svg" width="100"><img src="image/Allure_Report.svg" width="100"><img src="image/Telegram.svg" width="100">
### В проекте протестировано :mag_right:
* переход на главную страницу при клике по логотипу в хедере;
* структура меню хедера;
* переходы по пунктам меню хедера;
* ховер при наведении курсора на меню.
## Для запуска тестов
### локально в терминале :computer:
```
gradle clean test
```
### удаленно в Jenkins :desktop_computer:
[Пример сборки <img src="image/Jenkins.svg" width="100">](https://jenkins.autotests.cloud/job/012-sesterca-u13_employee_naumen_website/13/)
```
gradle clean test
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbaseUrl="${BASE_URL}"
-Dremote="${REMOTE}"
```
#### Параметры сборки
