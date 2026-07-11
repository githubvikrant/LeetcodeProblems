
var createHelloWorld = function() {
    
    return function(...args) {
        return "Hello World";
    }
};

let x = createHelloWorld();
x();

