def call() {
node 
  {
     stage('GitSCM')
    {
        git url: 'https://github.com/knagu/game-of-life.git'
    }
    stage('Build Stage')
    {
	   sh "${mvnHome}/bin/mvn -B clean install"
    }
  }
}
    
