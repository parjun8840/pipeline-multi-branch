 pipeline {
                             agent {label 'DONT-USE-THIS'}
                             libraries {
                                 lib("jenkins-series-library")
                             }
                          parameters {
                              booleanParam(name: "VAR_BOOLEAN", defaultValue: true, description: "Sample boolean parameter")
                              string(name: "VAR_STRING", defaultValue: "parjun8840", trim: true, description: "Sample string parameter")
                              text(name: "VAR_TEXT", defaultValue: "Jenkins Pipeline Tutorial", description: "Sample multi-line text parameter")
                              password(name: "VAR_PASSWORD", defaultValue: "SECRET", description: "Sample password parameter")
                              choice(name: "VAR_CHOICE", choices: ["production", "staging", "development"], description: "Sample multi-choice parameter")
                                     }
                             stages {
                                 stage('Build') {
                                     when {
                                        anyOf{
                                            environment name:  'DEPOLY_TO', value: 'production'
                                           environment name: 'some_name', value: 'parjun8840'
                                             }
                                           }
                                      steps {
                                       echo 'Hello World'
                                       script{
                                        foo()
                                         }
                                       echo "VAR_BOOLEAN $params.VAR_BOOLEAN"
                                       echo "VAR_STRING $params.VAR_STRING"
                                       echo "VAR_TEXT $params.VAR_TEXT"
                                       echo "VAR_PASSWORD $params.VAR_PASSWORD"
                                       echo "VAR_CHOICE $params.VAR_CHOICE"
                
                                           }
                                         }
                                    }
                                 }

                                    def foo(){
                                      list friends = ['A', 'B', 'C', 'D']
                                      for(item in friends) {
                                         println item
                                                           }
                                            }
