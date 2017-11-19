app.filter('cpf', function(){
  return function(cpf){
    return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3) + '-' + cpf.substr(9,2);
  };
});

app.filter('creditcard', function(){
  return function(cc, maskChar, sep){
    if(!sep)
      sep = '.';
        
    var maskedNum = Array(cc.length - 3).join(maskChar) + cc.substr(cc.length - 4, 4);
    maskedNum = maskedNum.substring(0, 4) + sep +
      maskedNum.substring(4, 8) + sep +
      maskedNum.substring(8, 12) + sep +
      maskedNum.substring(12, 16);
    return maskedNum;
  }
});

