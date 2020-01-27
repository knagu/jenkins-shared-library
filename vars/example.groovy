def call(Map config=[:]) {
node 
  {
	  def mvnHome = tool 'M2'
	  
	  stage ('workspace clean') {
	  cleanWs()	  
	  }
	  stage('GitSCM')
	  {
		  git url: 'https://github.com/knagu/game-of-life.git'
	  }	  
    	  stage('Build Stage')
	  {	   
	   sh "${mvnHome}/bin/mvn -B clean verify package"
	   echo "Build Successful"
	  }
	  stage('Test'){		  
		  sh "${mvnHome}/bin/mvn -B test"
		  echo "Tests successful"
	  }
	  stage('deploy') {
		  withCredentials( [usernamePassword( credentialsId: 'tomcat', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
		  sh "curl -u $USERNAME:$PASSWORD -T /var/lib/jenkins/workspace/ApplicationDemo@2/gameoflife-web/target/gameoflife.war 'http://localhost:8081/manager/text/deploy?path=/GameofLife&update=true'"
		  }
		  echo "Deploy successful"
	  }	 	 
  }
}
    
