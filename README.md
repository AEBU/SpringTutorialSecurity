# SpringTutorialSecurity
We have users into Memory to authenticate 



1)En spring initializer escoger
    Web
    Security 
    Thymeleaf
    
    NOTA: Vamos a crear los controladores para cada pagina que solicitaremos
    
2)Crear Page Views
    home
    welcome
    admin
    login
    403
3)SecurityConfig 
  
  vamos a tener 2 usuarios 
    admin
    user
 
  Crearemos Class que extienda de "WebSecurityConfigurerAdapter" y asi configuraremos nuestra pegticiones
  y pondremos nuestros usuarios en memoria
        auth
                   .inMemoryAuthentication()
                    .withUser("user").password("user").roles("USER")
       .and()
                   .withUser("admin").password("admin").roles("ADMIN");

#   Pequeño Resumen

    1) tenemos creado cada pagina para cada usuario de nuestra aplicacion
    2) si decimos que al logearse una persona como User este no podra acceder a la pagina /admin
    3) si decimos que una persona pone mal sus credenciales se usa el param.error y con ello podemos usar cada error y mandar un mensaje personalizado
    4)Tomar en cuenta que podemos poner @NotNull(message="") en los entity
    
    
    
    References
    http://javasampleapproach.com/spring-framework/spring-mvc/spring-security-config-security-mvc-web-spring-boot
    

  
