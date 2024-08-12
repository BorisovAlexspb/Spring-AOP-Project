#Документация

##Реализация логирования

Логика реализована в классе `LoggingAspect`.
Что логируется:
- вызовы методов get*(..)
- вызовы методов delete*(..)
- вызовы методов create*(..)
- вызов исключений

##Примеры pointcut
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
##Примеры advice

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
