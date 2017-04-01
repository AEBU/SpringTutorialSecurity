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

  
