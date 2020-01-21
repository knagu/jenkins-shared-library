def call(Map config=[:]) {
node 
  {
	  parameters{
		  string(defaultValue: "https://github.com/knagu/game-of-life.git", description: 'What environment?', name: 'gitUrl')
	  }	 
	  stage('GitSCM')
	  {
		  git url: ${params.gitUrl}
	  }
    	  stage('Build Stage')
	  {
	   def mvnHome = tool 'maven'
	   sh "${mvnHome}/bin/mvn -B clean install"    
	  }
	  stage('Test'){
		  if(config.Test)
		  echo "Tests successful"
	  }
	 
	 
  }
}
    
