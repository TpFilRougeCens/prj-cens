describe('Directeur', () => {

  beforeEach(() => {
    // On se connecte en tant qu'élève
    browser.get('/');
    element(by.model('username')).sendKeys('Directeur');
    element(by.model('password')).sendKeys('password');
    element(by.id('login')).click();

  });

  // on vérifie qu'il à bien accès au menu
  it('should have gestion in menu', () => {
    expect(element(by.id('nav-gestion')).isPresent()).toBeFalsy();
  });

});
