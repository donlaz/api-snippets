//Add participant
Set<String> participants = new HashSet<>();
participants.add("Alice");

//Send invite
outgoingInvite = conversationsClient.sendConversationInvite(participants, localMedia, new ConversationCallback() {
    @Override
    public void onConversation(Conversation conversation, ConversationException e) {
        if (e == null) {
            // Participant has accepted invite, we are in active conversation
            ConversationActivity.this.conversation = conversation;
        } else {
            hangup();
        }
    }
});