package fr.istic.agileProjet.config;

//
//@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
}
//
//    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);
//
//    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
//
//    /**
//     * Swagger Springfox configuration.
//     */
//    @Bean
//    public Docket swaggerSpringfoxDocket(final JHipsterProperties jHipsterProperties) {
//        log.debug("Starting Swagger");
//        final StopWatch watch = new StopWatch();
//        watch.start();
//        final ApiInfo apiInfo = new ApiInfo(jHipsterProperties.getSwagger().getTitle(),
//                jHipsterProperties.getSwagger().getDescription(), jHipsterProperties.getSwagger().getVersion(),
//                jHipsterProperties.getSwagger().getTermsOfServiceUrl(), jHipsterProperties.getSwagger().getContact(),
//                jHipsterProperties.getSwagger().getLicense(), jHipsterProperties.getSwagger().getLicenseUrl());
//
//        final Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
//                .genericModelSubstitutes(ResponseEntity.class).forCodeGeneration(true)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .directModelSubstitute(java.time.LocalDate.class, String.class)
//                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
//                .directModelSubstitute(java.time.LocalDateTime.class, Date.class).select()
//                .paths(regex(DEFAULT_INCLUDE_PATTERN)).build();
//        watch.stop();
//        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
//        return docket;
//    }
//}