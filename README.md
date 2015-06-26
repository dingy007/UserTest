# UserTest

Notes on Spring:

# BEAN WIRING:
- @Autowired is the Spring Annotation equivalent to JSR-250's @Resource, which is equivalent to JSR-330 @Inject annotation
  - Do take note that there are minor differences in how each look for a bean, example, @Resource prioritizes Bean-Type check over Bean-Name (unless specified)

# BEAN AUTO-DISCOVERY:
- <context-componentscan>com.myApp.beans</context-componentscan>

# APPLICATION CONTEXT:
Getting the Application-Context xml from filesystem
- FileSystemXmlApplicationContext - Get the xml from path from the file system (eg. C:/Users/MyApp/Application-context.xml)
- ClassPathXmlApplicationContext  - load based on relative path from the 'ClassPath', usually within a package location. (eg. com.MyApp.Contexts)
- WebXmlApplicationContext - load from within an web project
