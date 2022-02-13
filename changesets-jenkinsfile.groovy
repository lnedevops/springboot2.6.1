def label = "jnlp-agent"


timeout(time: 1800, unit: 'SECONDS') {
    podTemplate(label: label, cloud: 'kubernetes') {
        node(label) {
            stage('Git阶段') {
                // 执行 Git 命令进行 Clone 项目
                git changelog: true,
                        branch: "${params.GIT_BRANCH}",
                        credentialsId: "${params.GIT_CREDENTIAL}",
                        url: "${GIT_PROJECT_URL}"

                //调用方法得到日志并输出
                def changeString = getChangeString()
                echo "$changeString"

            }
        }
    }
}

//currentBuild.changeSets{
//    items[{
//        msg //提交注释
//        commitId //提交hash值
//        author{ //提交用户相关信息
//            id
//            fullName
//        }
//        timestamp
//        affectedFiles[{ //受影响的文件列表
//            editType{
//                name
//            }
//            path: "path"
//        }]
//        affectedPaths[// 受影响的目录，是个Collection<String>
//                "path-a","path-b"
//        ]
//    }]

def culprits = [:]     // git提交人
def commit_messages = [:]   // git提交变更信息
def affected_paths = [:]    // 已更改的文件列表
def commitTime = [:]    // git提交时间
@NonCPS
def getChangeString() {
    def changeString = ""
    def MAX_MSG_LEN = 100
    def changeLogSets = currentBuild.changeSets
    for (int i = 0; i < changeLogSets.size(); i++) {
        def entries = changeLogSets[i].items
        for (int j = 0; j < entries.length; j++) {
            def entry = entries[j]
            truncatedMsg = entry.msg.take(MAX_MSG_LEN)
            commitTime = new Date(entry.timestamp).format("yyyy-MM-dd HH:mm:ss")
            affectedFiles = entry.affectedFiles
            changeString += " - ${truncatedMsg} [${entry.author} ${commitTime}]\n"

        }
    }
    if (!changeString) {
        changeString = " - No new changes"
    }
    return (changeString)
}