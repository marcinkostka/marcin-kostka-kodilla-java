package com.kodilla.good.patterns.orderTask;

class InformationServiceData implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Thanks for buying " + user.getName() +
                ". Information about order was sent to your email: "+ user.getEmail());
    }
}
