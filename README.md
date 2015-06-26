# UserTest

Notes on Spring annotation:
- @Autowired is the Spring Annotation equivalent to JSR-250's @Resource, which is equivalent to JSR-330 @Inject annotation
  - Do take note that there are minor differences in how each look for a bean, example, @Resource prioritizes Bean-Type check over Bean-Name (unless specified)
