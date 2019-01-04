	
	
	//val cards = Array("2","3","4","5","6","7","8","9","10","11","12","13","14")
    
    //print(randc)

    trait carddrawBasic 
    {
    	this:person =>
    	var aceCounter =0
	    def cardcon(RIn:Int):String=
	    {

	    	var truenum = ""
	    	var sTnum = RIn.toString
	    	RIn match 
		    	{
		    		case 11 => truenum = "J"
		    		case 12 => truenum = "Q"
		    		case 13 => truenum = "K"
		    		case 14 => truenum = "A"
		    		case _ => truenum = sTnum
		    	}
	    	return truenum

	    }
// to do replace this section with a array so i can simulate the odds changing whance a card is drawn
	    def reInt(RIn:Int):Int=
	    	{
	    		
	    		var truenum = RIn
	    		RIn match 
		    	{
		    		case 11 => truenum = 10
		    		case 12 => truenum = 10
		    		case 13 => truenum = 10
		    		case 14 => {
		    			println("do you want A to = 1 or = 11 y for 1 n for 11")
		    			var y_n = scala.io.StdIn.readLine()
		    			if(y_n == "Y" || y_n == "y")
		    			{
		    				truenum = 1
		    			}
		    			else
		    			{
		    				truenum = 11
		    			}
		    			aceCounter = aceCounter +1
		    		}
		    		case _ => truenum = truenum
		    	}
		    	return truenum
	    	}


	}

	    //print(cardcon(randc))

class person extends carddrawBasic
{
	val r = new scala.util.Random
     
    var score = 1000
    var handscore = 0
    var i = 1
    def game()=
    {
    	var card= 2+r.nextInt(13)
    	var card2=2+r.nextInt(13)
    	println("draw two cards")
    	println("you drew: "+cardcon(card)+" and "+cardcon(card2))
    	println("your handscore is:")
    	handscore = handscore+reInt(card)+reInt(card2)
    	print(handscore)
    	while (i !=2)
    	{
			print("do you want to hit y/n")
			var y_n =scala.io.StdIn.readLine()
			  	if(y_n == "Y" || y_n == "y")
				{
					var extra_card=2+r.nextInt(13)
					handscore=handscore+ reInt(extra_card)
					println("you drew"+cardcon(extra_card)+"which makes your handscore:"+handscore)
					if(handscore >21)
					{
						print("you bust")
						i=2
					} 
				}
				else
				{
					i=2
				}
		}

    }

}

//val test = new person
//test.game()


class dealer extends person
	{
		def main() = 
		{
			game
			val r = new scala.util.Random
			var dealerhandscore = 0
			var dcard1=2+r.nextInt(13)
			var dcard2=2+r.nextInt(13)
			dealerhandscore = dcard1 + dcard2
			println("the dealer drew: "+cardcon(dcard1)+" and "+cardcon(dcard2))
			/*
			def dealerAceRule(score: Int) Int = 
			{
			var scoreChanged = 0
			scoreChanged = score-10
			return scoreChanged
			}
			*/
			while(dealerhandscore < 17 || dealerhandscore <= handscore)
			{
				var newcard = 2+r.nextInt(13)
				var dealerhandscoreAdd = dealerhandscore+newcard
				if( dealerhandscoreAdd >21 && cardcon(newcard) == "A")
				{
					dealerhandscore = dealerhandscore+1
					println("the dealer drew: "+cardcon(newcard)+"making his handscore"+dealerhandscore)
				}

				else
				{
					dealerhandscore += newcard
					println("the dealer drew: "+cardcon(newcard)+"making his handscore"+dealerhandscore)
				}
			}
			if (dealerhandscore < 21 && dealerhandscore> handscore)
			{
				println("dealer wins")
			}
			if(dealerhandscore >21 || handscore > dealerhandscore)
			{
				println("player wins")
			}
		}
   	}
   	val test = new dealer
   	test.main()