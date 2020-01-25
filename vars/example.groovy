def call(Map config=[:]) {
node 
  {
	  def mvnHome = tool 'M2'
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
	   
	   sh "${mvnHome}/bin/mvn -B clean install package"
	   echo "Build Successful"
	  }
	  stage('Test'){
		  //def mvnHome = tool 'M2'
		  sh "${mvnHome}/bin/mvn -B test"
		  echo "Tests successful"
	  }
	  stage('deploy') {
	          echo "Deploy successful"
	  }	 	 
  }
}
    
