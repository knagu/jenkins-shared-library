def call(Map config=[:]) {
node 
  {
	  stage('GitSCM')
	  {
		  git url: 'https://github.com/knagu/game-of-life.git'
	  }
    	  stage('Build Stage')
	  {
	   def mvnHome = tool 'maven'
	   sh "${mvnHome}/bin/mvn -B clean install"    
	  }
	  stage('Test'){
		  //if(config.Test)
		  echo "Tests successful"
	  }
	 
	 
  }
}
    
