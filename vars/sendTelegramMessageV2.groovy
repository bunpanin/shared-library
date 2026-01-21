def call(String message) {
                
    withCredentials([usernamePassword(credentialsId: 'TELEGRAM_BOT',
    passwordVariable: 'TOKEN', usernameVariable: 'CHAT_ID')]) {
      def encodedMessage = URLEncoder.encode(message, "UTF-8")
    sh """
        curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage \\
        -d chat_id=${CHAT_ID} \\
        -d text="${encodedMessage}" > /dev/null
    """

           
        
        
    }     

    
}
