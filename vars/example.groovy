def call(Map config=[:]) {
node 
  {
	  //properties([parameters([string(defaultValue: 'https://github.com/knagu/game-of-life.git', description: '', name: 'gitUrl', trim: false)])])	 
	  stage ('workspace clean') {
	  cleanWs()	  
	  }
	  stage('GitSCM')
	  {
		  git url: 'https://github.com/knagu/game-of-life.git'
	  }	  
    	  stage('Build Stage')
	  {
	   def mvnHome = tool 'M2'
	   sh "${mvnHome}/bin/mvn -B clean install package"
	   echo "Build Successful"
	  }
	  stage('Test'){
		  sh "${mvnHome}/bin/mvn -B test"
		  echo "Tests successful"
	  }
	  stage('deploy') {
	          echo "Deploy successful"
	  }	 	 
  }
}
    
