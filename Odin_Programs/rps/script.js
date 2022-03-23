// This is a scissors, paper, rock game. It should be played from the console for now and use a graphical interface later.
function computerPlay() {
    let randInt = Math.floor(Math.random() * 3); // Random int between 0 and 2
    let word;
    if (randInt===0) {
        word = 'paper';
    } else if (randInt===1) {
        word = 'scissors';
    } else if (randInt===2) {
        word = 'rock';
    } else {
        word = 'wtf happened to my random number generator';
    }
    return word;
}

function play(playerSelection, computerSelection) {
    if (playerSelection === computerSelection) {
        return 'Draw!';
    }

    if (playerSelection === 'rock' && computerSelection === 'scissors') {
        return 'You Win! Rock beats Scissors';
    } else if (playerSelection === 'rock' && computerSelection === 'paper') {
        return 'You Lose! Paper beats Rock';
    } else if (playerSelection === 'paper' && computerSelection === 'rock') {
        return 'You Win! Paper beats Rock';
    } else if (playerSelection === 'paper' && computerSelection === 'scissors') {
        return 'You Lose! Scissors beats Paper';
    } else if (playerSelection === 'scissors' && computerSelection ==='paper') {
        return 'You Win! Scissors beats Paper';
    } else if (playerSelection === 'scissors' && computerSelection === 'rock') {
        return 'You Lose! Rock beats Scissors';
    } else {
        return 'This is a problem with the who beats who section';
    }
}

function playerPlay() {
    return (window.prompt("Paper, Scissors or Rock?: ")).toLowerCase();
}

function game() {
    let playerRounds = 0;
    let computerRounds = 0;
    for (let i = 0; i < 5; i++) {
        let player = playerPlay();
        let computer = computerPlay();
        let result = play(player, computer);
        console.log(result);
        if (result.charAt(4) === 'W') {
            playerRounds += 1;
        } else if (result.charAt(4) === 'L') {
            computerRounds += 1;
        } else {
            console.log('We have a problem with determining the winner');
        }
    }
    if (playerRounds > computerRounds) {
        console.log(`You win ${playerRounds}:${computerRounds}`);
    } else if (playerRounds < computerRounds) {
        console.log(`You lose ${playerRounds}:${computerRounds}`);
    } else {
        console.log("It's a draw!");
    }
}

game()