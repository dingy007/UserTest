# UserTest

Notes on Spring:

# BEAN WIRING:
<ul>
	<li>@Autowired is the Spring Annotation equivalent to JSR-250's @Resource, which is equivalent to JSR-330 @Inject annotation
	<ul>
  		<li>Do take note that there are minor differences in how each look for a bean, example, @Resource prioritizes Bean-Type check over Bean-Name (unless specified)</li>
  	</ul>
	<li>Injecting Values to Bean-Properties:</li>
	<ul>
  		<li>Use @Value</li>
  		<li>eg. void setIdVal ( @Value("NewValueToInject") Id id)</li>
  	</ul>
</ul>

# BEAN AUTO-DISCOVERY:
- &lt;context-componentscan>com.myApp.beans&lt;/context-componentscan>

# APPLICATION CONTEXT:
<ul>
	<li>Getting the Application-Context xml from filesystem</li>
	<ul>
		<li>FileSystemXmlApplicationContext - Get the xml from path from the file system (eg. C:/Users/MyApp/Application-context.xml)</li>
		<li>ClassPathXmlApplicationContext  - load based on relative path from the 'ClassPath', usually within a package location. (eg. com.MyApp.Contexts)</li>
		<li>WebXmlApplicationContext - load from within an web project</li>
	</ul>
</ul>

# SPEL
<ul>
	<li>Use <b>#{}</b> to evaluate Spring Expression Language.</li>
	<li>Can be used to get a method or property of another bean eg. &lt;property name="personality" value="#{MyProperties.getPersonality()}">&lt;/property></li>
	<li><b>?. operator will only invoke the succeeding code, if the preceeding code is not null</b></li>
</ul>

# JSP Tricks:
<ul>
	<li>Getting the Application's context path:</li>
		<ul>
			<li>Using JSTL 'c' tag: </li>
			<ul>
				<li>Eg. &lt;p> &lt;a href="&lt;c:url value="/toDestination"/>">Click Here!&lt;/a></li>
			</ul>
			<li>Using Spring's Expression language (SPEL): </li>
			<ul>
				<li>Eg. "${pageContext.request.contextPath}/login"</li>
			</ul>
		</ul>
	<li>Enabling CSRF (Cross-Site Request Forgery) Protection in Spring Forms</li>
		<ul>
			<li>&lt;input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></li>
		</ul>
</ul>
