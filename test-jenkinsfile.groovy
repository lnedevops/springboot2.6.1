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

                    def changelogString = gitChangelog returnType: 'STRING',
                            from: [type: 'REF', value: '0.0.01'],
                            to: [type: 'REF', value: 'master'],
                            template: """

  // Template is documented below!
  # Changelog

Changelog for {{ownerName}} {{repoName}}.

{{#tags}}
## {{name}}
 {{#issues}}
  {{#hasIssue}}
   {{#hasLink}}
### {{name}} [{{issue}}]({{link}}) {{title}} {{#hasIssueType}} *{{issueType}}* {{/hasIssueType}} {{#hasLabels}} {{#labels}} *{{.}}* {{/labels}} {{/hasLabels}}
   {{/hasLink}}
   {{^hasLink}}
### {{name}} {{issue}} {{title}} {{#hasIssueType}} *{{issueType}}* {{/hasIssueType}} {{#hasLabels}} {{#labels}} *{{.}}* {{/labels}} {{/hasLabels}}
   {{/hasLink}}
  {{/hasIssue}}
  {{^hasIssue}}
### {{name}}
  {{/hasIssue}}

  {{#commits}}
**{{{messageTitle}}}**

{{#messageBodyItems}}
 * {{.}}
{{/messageBodyItems}}

[{{hash}}](https://gitlab.com/{{ownerName}}/{{repoName}}/commit/{{hash}}) {{authorName}} *{{commitTime}}*

  {{/commits}}

 {{/issues}}
{{/tags}}
  """

                    currentBuild.description = changelogString
                }
            }
        }
    }
