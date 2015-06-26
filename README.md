# UserTest

Notes on Spring:

# BEAN WIRING:
- @Autowired is the Spring Annotation equivalent to JSR-250's @Resource, which is equivalent to JSR-330 @Inject annotation
  - Do take note that there are minor differences in how each look for a bean, example, @Resource prioritizes Bean-Type check over Bean-Name (unless specified)
- Injecting Values to Bean-Properties:
  - use @Value
  - eg. void setIdVal ( @Value("NewValueToInject") Id id)

# BEAN AUTO-DISCOVERY:
- &lt;context-componentscan>com.myApp.beans&lt;/context-componentscan>

# APPLICATION CONTEXT:
Getting the Application-Context xml from filesystem
- FileSystemXmlApplicationContext - Get the xml from path from the file system (eg. C:/Users/MyApp/Application-context.xml)
- ClassPathXmlApplicationContext  - load based on relative path from the 'ClassPath', usually within a package location. (eg. com.MyApp.Contexts)
- WebXmlApplicationContext - load from within an web project
- 

 # SPEL
- Use #{} to evaluate Spring Expression Language.
- Can be used to get a method or property of another bean eg. <property name="personality" value="#{MyProperties.getPersonality()}"></property>
#- ?. operator will only invoke the succeeding code, if the preceeding code is not null
