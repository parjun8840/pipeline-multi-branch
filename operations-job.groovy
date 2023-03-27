folder('operations') {
  displayName('operations')
  description('Operations related all Jobs')
}

folder('operations/sre/monitoring') {
  displayName('sre-monitoring')
  description('sre monitoring related Jobs')
}


folder('operations/devops/k8s') {
  displayName('devops-k8s')
  description('devops K8s related Jobs')
}

folder('operations/common/prod') {
  displayName('common-prod')
  description('operations common prod related Job')
}

folder('operations/common/dev') {
  displayName('common-dev')
  description('operations common dev related Job')
}


pipelineJob("operations/common/dev/basic-setup") {
  logRotator(10,-1,1,-1)
definition {
                cps {
                    script('''
                         pipeline {
                             agent any
                             libraries {
                                 lib("pipeline-lib@master")
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
                                       echo "VAR_BOOLEAN $params.VAR_BOOLEAN"
                                       echo "VAR_STRING $params.VAR_STRING"
                                       echo "VAR_TEXT $params.VAR_TEXT"
                                       echo "VAR_PASSWORD $params.VAR_PASSWORD"
                                       echo "VAR_CHOICE $params.VAR_CHOICE"
                
                                           }
                                         }
                                    }

                    ''')
                    
                }
            }
            }
            }