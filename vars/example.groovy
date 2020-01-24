def call(Map config=[:]) {
node 
  {
	  //properties([parameters([string(defaultValue: 'https://github.com/knagu/game-of-life.git', description: '', name: 'gitUrl', trim: false)])])	 
	  stage('GitSCM')
	  {
		  git url: 'https://github.com/knagu/game-of-life.git'
	  }	  
    	  stage('Build Stage')
	  {
	   def mvnHome = tool 'M2'
	   sh "${mvnHome}/bin/mvn -B clean install"
	   echo "Build Successful"
	  }
	  stage('Test'){
		  echo "Tests successful"
	  }
	  Stage('deploy') {
	          echo "Deploy successful"
	  }	 	 
  }
}
    
