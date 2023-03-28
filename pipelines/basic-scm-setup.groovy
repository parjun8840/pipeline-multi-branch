pipelineJob('"operations/common/dev/basic-scm-setup"') {
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

