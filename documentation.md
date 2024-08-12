<h1>Документация</h1>

<h2>Реализация логирования</h2>

Логика реализована в классе `LoggingAspect`.
Что логируется:
- вызовы методов get*(..)
- вызовы методов delete*(..)
- вызовы методов create*(..)
- вызов исключений

<h3>Примеры pointcut</h3>
- поинткат на вызов исключения
```
@Pointcut("@annotation(com.example.demo.annotations.Exception)")
public void exceptionPointcut() {
}
```
- поинткат на метод get*(..)
```
@Pointcut("execution(* com.example.demo.service.jpa.*.get*(..))")
  public void logPointcutServicesForGetMethod() {
}
```
<h3>Примеры advice</h3>

- Логирование перед выполнением метода create*(..)
```
@Before("logPointcutServicesForCreateMethod()")
public void logMethodCallsWithinAdviceForCreateMethod(JoinPoint joinPoint) {
logger.info("Create method <<{}>> is running", joinPoint.getSignature().getName());
}
```
- Логирование после вызова исключения
```
@AfterThrowing(pointcut = "exceptionPointcut()", throwing = "ex")
    public void logMethodThrowingException(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exception in {} method () - {}", methodName, ex.getMessage());
 }
```
