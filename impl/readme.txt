********************************************************************************************************************************
Showtimes project.

********************************************************************************************************************************
Usage: mvn cf:command [command_options]

Currently available Cloud Foundry Maven Plugin Goals are:

  Getting Started
    info -Dcf.username -Dcf.password                                        System and account information

  Applications
    apps -Dcf.username -Dcf.password                                        List deployed applications

  Application Creation
    push -Dcf.username -Dcf.password [-Dcf.appname]                         Create, push, map, and start a new application
    push -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.warfile]          Push application from specified path
    push -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.url]              Set the url for the application
    push -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.instances]        Set the expected number of instances
    push -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.memory]           Set the memory reservation for the application
    push -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.services]         Set the runtime to use for the application
    push -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.no-start]         Do not auto-start the application

  Application Operations
    start   -Dcf.username -Dcf.password [-Dcf.appname]                      Start the application
    stop    -Dcf.username -Dcf.password [-Dcf.appname]                      Stop the application
    restart -Dcf.username -Dcf.password [-Dcf.appname]                      Restart the application
    delete  -Dcf.username -Dcf.password [-Dcf.appname]                      Delete the application

  Application Updates
    update    -Dcf.username -Dcf.password [-Dcf.warfile]                    Update the application bits
    instances -Dcf.username -Dcf.password [-Dcf.appname] [-Dcf.instances]   Scale the application instances up or down

  Administration
    add-user    -Dcf.username -Dcf.password                                 Register a new user
    register    -Dcf.username -Dcf.password                                 Register a new user (Alias for 'add-user')
    delete-user -Dcf.username -Dcf.password                                 Delete a user and all apps and services

  Application Information
    instances -Dcf.username -Dcf.password [-Dcf.appname]                    List application instances

  Help
    help                                                                    Get general help
********************************************************************************************************************************

mvn clean install cf:update -Dcf.username=<username> -Dcf.password=<password>
