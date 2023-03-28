folder('operations') {
  displayName('operations')
  description('Operations related all Jobs')
}

folder('operations/sre') {
  displayName('operations-sre')
  description('Operations related all Jobs for sre')
}

folder('operations/sre/monitoring') {
  displayName('sre-monitoring')
  description('sre monitoring related Jobs')
}

folder('operations/devops') {
  displayName('operations-devops')
  description('devops K8s related Jobs for devops')
}

folder('operations/devops/k8s') {
  displayName('devops-k8s')
  description('devops K8s related Jobs')
}

folder('operations/common') {
  displayName('common')
  description('operations common Jobs for Sre and DevOps')
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
                                     when {expression { return params.VAR_BOOLEAN } }
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
                                       
                    ''')
                   } 
                }
            }

pipelineJob("operations/common/dev/basic-scm-setup") {
    definition {
        cpsScm {
            scm {
                git('https://github.com/parjun8840/pipeline-multi-branch.git')
            }
            scriptPath("pipelines/basic-scm-setup.groovy")
            lightweight(true)
        }
    }
}
