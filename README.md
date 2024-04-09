# Инструкция по установке и запуску проекта CRUDtelefon

## 1. Настройка окружения

### 1.1 Java
Проект использует Java версии 21.

### 1.2 PostgreSQL
- Username: postgres
- Password: beka asd2020
- URL DataBase: jdbc:postgresql://localhost:5432/CRUDtelefon

### 1.3 MongoDB
- Username: zalgasovbeksultan1
- Password: beka-asd2020
- URL DataBase: mongodb+srv://zalgasovbeksultan1:beka-asd2020@cluster0.ytvls4a.mongodb.net/ContactMongoDB?retryWrites=true&w=majority

### 1.4 Gradle
Используется Gradle версии 8.5.

## 2. Запуск проекта

### 2.1 Скачивание проекта
```bash
git clone https://github.com/Beksultan2020/Telephony/tree/master
```
-или переходим по этой ссылке в браузере
```bash
https://github.com/Beksultan2020/Telephony/tree/master
```
- нажимаем на main и выбираем master
- нажимаем на commits и там выбираем Final version
- нажимаем на <> code
- высветимшее окне нажимаем на Download ZIP

### 2.1.1 Скачивание проекта через github
- заходим по этой ссылке к финальней версии
```bash
https://github.com/Beksultan2020/Telephony/tree/edc613f63a5ecb4175715af87f247842f5c3e0d2
```
- нажимаем на <> code
- высветимшее окне нажимаем на Download ZIP


### 2.2 Импорт проекта в IntelliJ IDEA
- Откройте вашу среду разработки.
- Импортируйте проект из склонированного репозитория.

### 2.3 Запуск приложения
- Запустите приложение из вашей среды разработки.

### 2.4 Проверка работоспособности
- После успешного запуска приложения, откройте браузер и перейдите по адресу:
```bash
http://localhost:8090/firstContacts
```
- или
```bash
 http://localhost:8090/secondContacts
```

## 3. Импорт Postman коллекции
- Откройте Postman.
- Импортируйте файл FirstCrudSQL.postman_collection.json и SecondCrudMongoDB.postman_collection.json
- Воспользуйтесь импортированными запросами для тестирования API.

## 4. Описание контроллеров и входных параметров

### 4.1 ContactControllerSQL

Этот контроллер обрабатывает запросы, связанные с контактами в SQL базе данных.

Методы:
- getAllContacts() - Получить список всех контактов.
- getContactById(Long id) - Получить контакт по его ID.
- getContactByPhoneNumber(String phoneNumber) - Получить контакт по его номеру телефона.
- getAllFilteredContacts(Filter filter) - Получить список контактов с примененным фильтром.
- createContact(ContactSQL contactSQL) - Создать новый контакт.
- updateContactById(Long id, ContactSQLDto contactSQLDto) - Обновить контакт по его ID.
- updateContactByPhoneNumber(String phoneNumber, ContactSQLDto contactSQLDto) - Обновить контакт по его номеру телефона.
- deleteContactById(Long id) - Удалить контакт по его ID.
- deleteContactByPhoneNumber(String phoneNumber) - Удалить контакт по его номеру телефона.

### 4.2 ContactMongoDBController

Этот контроллер обрабатывает запросы, связанные с контактами в MongoDB.

Методы:
- getAllContacts() - Получить список всех контактов.
- getContactById(String id) - Получить контакт по его ID.
- getContactByPhoneNumber(String phoneNumber) - Получить контакт по его номеру телефона.
- createContact(ContactMongoDB contactMongoDB) - Создать новый контакт.
- updateContactById(String id, ContactMongoDBDto contactMongoDBDto) - Обновить контакт по его ID.
- updateContactByPhoneNumber(String phoneNumber, ContactMongoDBDto contactMongoDBDto) - Обновить контакт по его номеру телефона.
- deleteContactById(String id) - Удалить контакт по его ID.
- deleteContactByPhoneNumber(String phoneNumber) - Удалить контакт по его номеру телефона.

## 5. TestNG

### Проверка тестов

- Запускаем тесты и смотрим что все тесты работают правильно

### Описание тестов

## Аннотации:

Здесь идут аннотации, которые предоставляют метаданные о классе или методе. В этом случае используются следующие аннотации:

- @SpringBootTest: Эта аннотация указывает, что данный класс является тестом Spring Boot и должен быть запущен как Spring Boot приложение для выполнения тестов.

- @Transactional: Эта аннотация указывает, что каждый тестовый метод должен быть выполнен в транзакции, которая будет откатываться после выполнения теста, чтобы не вносить изменения в базу данных.

- @Mock: Эта аннотация указывает, что поле contactSQLService будет использоваться как макет (mock) объекта. Mockito будет создавать макет этого объекта для использования в тестах.

## Методы:

- setup(): Этот метод помечен аннотацией @BeforeMethod, что означает, что он будет выполняться перед каждым тестовым методом. В этом методе вызывается MockitoAnnotations.openMocks(this), чтобы проинициализировать все поля с аннотацией @Mock.

- testGetAllContacts(): Этот метод помечен аннотацией @Test и содержит реализацию теста. Внутри этого метода:

    - Создаются два объекта ContactSQLDto с помощью метода createContact().
    - Затем с помощью Mockito настраивается поведение макета contactSQLService: когда вызывается метод getAllContacts(), он должен вернуть список, содержащий созданные контакты.
    - Вызывается метод getAllContacts() реального сервиса contactSQLService, и результат сохраняется в переменной allContacts.
    - Проверяется, что список allContacts не является null, содержит два элемента и что имена этих элементов совпадают с именами созданных контактов.

- createContact(): Этот метод используется для создания объекта ContactSQLDto с заданными параметрами. Внутри метода создается объект ContactSQL, заполняются его поля и вызывается метод createContact() реального сервиса contactSQLService, который возвращает объект ContactSQLDto.

Таким образом, этот код представляет собой набор тестов для проверки функциональности сервиса, который работает с контактами. В тесте проверяется корректность получения списка всех контактов.

## 6. Mapper

- В своем проекте я добавил mapper потому что это позволяет удобно и эффективно выполнять преобразование между объектами DTO (Data Transfer Object) и сущностями базы данных.
- Использование mapper помогает избежать дублирования кода и упрощает поддержку проекта, так как логика преобразования инкапсулируется в отдельном компоненте, который легко изменить или расширить при необходимости.
- Еще одна из причин, чтобы не писать Builder, это значительно сокращает объем кода и упрощает процесс создания экземпляров объектов с множеством параметров.

  ## 7. Liquibase
- Из миграции данных я использовал liquibase для SQL таблиц.
