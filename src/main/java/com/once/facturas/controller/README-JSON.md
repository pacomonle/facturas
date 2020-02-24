
@ResponseBody, ResponseEntity Spring devuelve el objeto como JSON


@RequestMapping(value = "/resources/users", method = RequestMethod.GET)
public ResponseEntity<User> getUserByLogonId(OAuth2Authentication auth) {

    String userLogonId = ((org.springframework.security.core.userdetails.User) auth.getUserAuthentication()
            .getPrincipal()).getUsername();
    UsersServices usersServices = new UsersServicesImpl(usersOperations);
    User user = usersServices.findByLogonId(userLogonId);
    HttpStatus userStatus = HttpStatus.NOT_FOUND;
    if (user != null) {
        userStatus = HttpStatus.FOUND;
    }
    return new ResponseEntity<User>(user, userStatus);
}



@RestController es una anotación de estereotipos que combina @ResponseBody y @Controller. Más que eso, le da más significado a su Controlador y también puede llevar semánticas adicionales en futuras versiones del marco.