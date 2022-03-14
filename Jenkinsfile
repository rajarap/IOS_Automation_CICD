def IOS_RECP
def PROJECT_SCHEME_BETA

pipeline
{
    agent { label 'label-master'}

    tools
    {
        jdk 'OPENJDK11'
        gradle 'GRADLE'
        git 'GIT'
        maven 'MAVEN'
        xcode 'XCODE'
    }

    environment
    {
        JAVA_HOME="/usr/local/Cellar/openjdk@11/11.0.12/libexec/openjdk.jdk/Contents/Home"   
        SCANNER="/Applications/sonar-scanner"
    }
  
    parameters
    {
      string description: 'Contains the Job name', name: 'FROM_JOB_NAME'
      string description: 'Contains the Build Number', name: 'FROM_BUILD_NUMBER'
    } 

    stages
    {
        stage('Loading Pipeline Properties')
        {
            steps
            {
                script
                {
                    def properties = readProperties file: 'pipeline.properties'
                    IOS_RECP = properties['IOS_RECP']
                    PROJECT_SCHEME_BETA = properties['PROJECT_SCHEME_BETA']
                }
            }
        }

        stage('Execute QA Automated Test Scripts for Manually Selected Branch')
        {
            when 
            {
                allOf
                {
                    expression { params.FROM_JOB_NAME == 'Arris_iOS_Manually_Build_Any_Branch_Or_Tag' }
                    expression { params.QA_AUTOMATION  == true }
                }
            }

            steps
            {
                echo '===== Automated Test Started ====='
                
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') 
                {
                	sh """
                        ios-deploy --debug --bundle /Users/rm2652/.jenkins/workspace/ipa/${PROJECT_SCHEME_BETA}/SBC Test.ipa
                        mvn -f /Users/rm2652/.jenkins/workspace/Arris_iOS_QA_Automation_W31_BOBA/pom.xml test -PiOS
                		"""   
                }
                
                echo '=====Automated Test Completed====='
            }
        }
      
        stage('Execute QA Automated Test Scripts for Manually Selected Branch EXP')
        {
            when 
            {
                allOf
                {
                    expression { params.FROM_JOB_NAME == 'Arris_iOS_Manually_Build_Any_Branch_Or_Tag_EXP' }
                    expression { params.QA_AUTOMATION  == true }
                }
            }

            steps
            {
                echo '===== Automated Test Started ====='
                
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') 
                {
                	sh """
                        ios-deploy --debug --bundle /Users/rm2652/.jenkins/workspace/ipa/${PROJECT_SCHEME_BETA}/SBC Test.ipa
                        mvn -f /Users/rm2652/.jenkins/workspace/Arris_iOS_QA_Automation_W31_BOBA/pom.xml test -PiOS
                		"""   
                }
                
                echo '=====Automated Test Completed====='
            }
        }

        stage('Execute QA Automated Test Scripts for Master Branch')
        {
            when 
            {
                allOf
                {
                    expression { params.FROM_JOB_NAME == 'Arris_iOS_Master_Branch_3am_Auto_Build' }
                    expression { params.QA_AUTOMATION  == true }
                }
            }

            steps
            {
                echo '===== Automated Test Started ====='
                
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') 
                {
                	sh """
                    	ios-deploy --debug --bundle /Users/rm2652/.jenkins/workspace/ipa/${PROJECT_SCHEME_BETA}/SBC Test.ipa
                    	mvn -f /Users/rm2652/.jenkins/workspace/Arris_iOS_QA_Automation_W31_BOBA/pom.xml test -PiOS
               		 """       
                }
                echo '=====Automated Test Completed====='
            }
        }

        stage('Publish Reports')
        {
            steps
            {
                echo '=====Publish QA ReportNG Report====='
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, 
                    reportDir: 'mvn -f /Users/rm2652/.jenkins/workspace/Arris_iOS_QA_Automation_W31_BOBA/pom.xml test -PiOS/target/surefire-reports/html', reportFiles: 'index.html', 
                    reportName: 'W31 iOS Onboarding BOBA', reportTitles: 'Arris SURFboard App'])

                    zip archive: true, dir: '/Users/rm2652/.jenkins/workspace/Arris_iOS_QA_Automation_W31_BOBA/target/surefire-reports/html', zipFile: 'W31_iOS_Onboarding_BOBA_'+params.FROM_BUILD_NUMBER+'.zip'

             }
        }
    }

    post
    {
        success
        {
            echo 'Jenkins job ' + env.JOB_NAME + ' ' + env.BUILD_NUMBER +' '+ env.BUILD_TIMESTAMP + ' - SUCCESS '                
            emailext body: '''${SCRIPT, template="groovy-html.template"}''',
            subject: 'Job \'${JOB_NAME}\' - (${BUILD_NUMBER}) - \'${BUILD_TIMESTAMP}\' -  SUCCESS',
            mimeType: 'text/html',
            to: 'prabhu.rajarathinam@mobileprogramming.com'
            //to: "${IOS_RECP}"
        }

        failure
        {
            echo 'Jenkins job ' + env.JOB_NAME + ' ' + env.BUILD_NUMBER +' '+ env.BUILD_TIMESTAMP + ' - FAILED ' 
            emailext body: '''${SCRIPT, template="groovy-html.template"}''', 
            subject: 'Job \'${JOB_NAME}\' - (${BUILD_NUMBER}) - \'${BUILD_TIMESTAMP}\' - FAILED',
            mimeType: 'text/html',
            attachLog: true, 
            to: 'prabhu.rajarathinam@mobileprogramming.com'
            //to: "${IOS_RECP}"
        }

        unstable
        {
            echo 'Jenkins job ' + env.JOB_NAME + ' ' + env.BUILD_NUMBER +' '+ env.BUILD_TIMESTAMP + ' - UNSTABLE ' 
            emailext body: '''${SCRIPT, template="groovy-html.template"}''', 
            subject: 'Job \'${JOB_NAME}\' - (${BUILD_NUMBER}) - \'${BUILD_TIMESTAMP}\' - UNSTABLE',
            mimeType: 'text/html',
            attachLog: true, 
            to: 'prabhu.rajarathinam@mobileprogramming.com'
            //to: "${IOS_RECP}"
        }
    }
}
