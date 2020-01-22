package org.example

def call(Map config=[:]) {
node 
  {
	  //properties([parameters([string(defaultValue: 'https://github.com/knagu/game-of-life.git', description: '', name: 'gitUrl', trim: false)])])	 
	  //stage('GitSCM')
	  //{
	//	  git url: 'https://github.com/knagu/game-of-life.git'
	  //}	  
    	  stage('Build Stage')
	  {
	   def mvnHome = tool 'M2'
	   sh "${mvnHome}/bin/mvn -B clean install"    
	  }
	  stage('Test'){
		  if(config.Test)
		  echo "Tests successful"
	  }
	 
	 
  }
}
