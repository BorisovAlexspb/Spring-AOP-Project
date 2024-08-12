# Отчёт по проекту Spring AOP

Данный проект демонстрирует пример использования Spring AOP для логирования операций в приложении, имитирующем управление пользователями и их заказами. 
Проект написан на `Java 21` с использованием `Spring Boot 3`. Для работы требуется БД `PostgreSQL`.

## Инструкция по запуску

### Запуск приложения

Для запуска приложения необходимо перейти в корень проекта и выполнить команды:

```
mvn install
mvn spring-boot:run
```
### Запуск базы данных

В проекте используется база данных PostgreSQL. В файле `application.properties` необходимо указать URL, имя пользователя и пароль. Затем выполните команду:
```
docker-compose up
```
### Запуск тестов

Для запуска тестов выполните команду:
```
mvn test
```
## Логирование

Для логирования используется библиотека `Log4j2`. Конфигурация описана в файле `log4j2.xml`. Используется базовая конфигурация для вывода логов в консоль.

## Примеры логирования

Логирование вызова метода createOrder():

```
main] com.example.demo.aspect.LoggingAspect : Create method <<createOrder>> is running
```
Логирование выброса исключения:
```
main] com.example.demo.aspect.LoggingAspect : Exception in createOrder method () - User does not exist
```
## Примеры тестов

Тест создания пользователя:
```
@Test
void testCreateUser() {
    User user = new User();
    when(userRepository.save(user)).thenReturn(user);

    User result = userService.createUser(user);
    assertNotNull(result);
    assertEquals(user, result);
}
```

