def call(Map config=[:]) {
node 
  {
	  properties([parameters([string(defaultValue: 'Enter Git Url', description: '', name: 'gitUrl', trim: false)])])	 
	  stage('GitSCM')
	  {
		  git url: "${params.gitUrl}"
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
    
