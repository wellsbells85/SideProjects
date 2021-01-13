package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
		System.out.println(remainingNumberOfBirds);
        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println(numberOfExtraBirds);
		
        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsPlayingInTheWoods = 3;
		int raccoonsThatWentHomeForDinner = 2;
		int racconsLeftInTheWoods = raccoonsPlayingInTheWoods - raccoonsThatWentHomeForDinner;
		System.out.println(racconsLeftInTheWoods);
		
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberOfFlowersMinusBees = numberOfFlowers - numberOfBees;
		System.out.println(numberOfFlowersMinusBees);
		
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfPigeons = 1;
		numberOfPigeons++;
		System.out.println(numberOfPigeons);
		
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsSittingOnFence = 3;
		int owlsThatJoinOnFence = 2;
		owlsSittingOnFence += owlsThatJoinOnFence;
		System.out.println(owlsSittingOnFence);
	
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorkingOnHome = 2;
		int beaversWentForASwim = 1;
		int beaversStillWorkingOnHome = beaversWorkingOnHome - beaversWentForASwim;
		System.out.println(beaversStillWorkingOnHome);

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansSittingOnTreeLimb = 2;
		int toucansThatJoinOnTreeLimb = 1;
		toucansSittingOnTreeLimb += toucansThatJoinOnTreeLimb;
		System.out.println(toucansSittingOnTreeLimb);

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int howManyMoreSquirrelsThanNuts = numberOfSquirrels - numberOfNuts;
		System.out.println(howManyMoreSquirrelsThanNuts);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		float numberOfQuarters = 1.0F;
		float numberOfDimes = 1.0F;
		float numberOfNickels = 2.0F;
		float totalAmountOfMoneyInDollars = numberOfQuarters * .25F + numberOfDimes * .10F + numberOfNickels * .05F;
		System.out.println(totalAmountOfMoneyInDollars);
		
		/*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int numberOfMuffinsMrsBrierClass = 18;
		int numberOfMuffinsMrsMacadamsClass = 20;
		int numberOfMuffinsMrsFlanneryClass = 17;
		int totalNumberOfMuffinsFirstGrade = numberOfMuffinsMrsBrierClass + numberOfMuffinsMrsMacadamsClass + numberOfMuffinsMrsFlanneryClass;
		System.out.println(totalNumberOfMuffinsFirstGrade);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		int priceOfYoyoInCents = 24;
		int priceOfWhistleInCents = 14;
		int totalSpentOnToysInCents = priceOfYoyoInCents + priceOfWhistleInCents;
		System.out.println(totalSpentOnToysInCents);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numberOfLargeMarshmallow = 8;
		int numberOfMiniMarshmallow = 10;
		int totalNumberOfMarshmallow = numberOfLargeMarshmallow + numberOfMiniMarshmallow;
		System.out.println(totalNumberOfMarshmallow);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesOfSnowfallMrsHiltHouse = 29;
		int inchesOfSnowfallBrecknockSchool = 17;
		int differenceInSnowfallInInches = inchesOfSnowfallMrsHiltHouse - inchesOfSnowfallBrecknockSchool;
		System.out.println(differenceInSnowfallInInches);
		
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int startingDollarAmountMrsHilt = 10;
		int priceToyTruckInDollars = 3;
		int pricePencilInDollars = 2;
		int currentDollarAmountMrsHilt = startingDollarAmountMrsHilt - priceToyTruckInDollars - pricePencilInDollars;
		System.out.println(currentDollarAmountMrsHilt);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int numberOfMarblesInCollection = 16;
		int numberOfMarblesLost = 7;
		numberOfMarblesInCollection -= numberOfMarblesLost;
		System.out.println(numberOfMarblesInCollection);
		
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int numberOfSeashellsMeganHas = 19;
		int numberOfSeashellsMeganWants = 25;
		int numberOfSeashellsMeganNeeds = numberOfSeashellsMeganWants - numberOfSeashellsMeganHas;
		System.out.println(numberOfSeashellsMeganNeeds);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int numberOfBalloonsTotal = 17;
		int numberOfRedBalloons = 8;
		int numberOfGreenBalloons = numberOfBalloonsTotal - numberOfRedBalloons;
		System.out.println(numberOfGreenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int numberOfBooksOnShelf = 38;
		int numberOfBooksMartaAddsToShelf = 10;
		numberOfBooksOnShelf += numberOfBooksMartaAddsToShelf;
		System.out.println(numberOfBooksOnShelf);

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfLegsOnBee = 6;
		int numberOfBeesTotal = 8;
		int numberOfLegsTotal = numberOfLegsOnBee * numberOfBeesTotal;
		System.out.println(numberOfLegsTotal);

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		float costIceCreamConeInDollars = .99F;
		int numberOfIceCreamCones = 2;
		float costInDollarsTotal = costIceCreamConeInDollars * numberOfIceCreamCones;
		System.out.println(costInDollarsTotal);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int numberOfRocksMrsHiltNeeds = 125;
		int numberOfRocksMrsHiltHas = 64;
		numberOfRocksMrsHiltNeeds -= numberOfRocksMrsHiltHas;
		System.out.println(numberOfRocksMrsHiltNeeds);

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int numberOfMarblesMrsHiltHas = 38;
		int numberOfMarblesMrsHiltLost = 15;
		numberOfMarblesMrsHiltHas -= numberOfMarblesMrsHiltLost;
		System.out.println(numberOfMarblesMrsHiltHas);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalMilesDrivenToConcert = 78;
		int totalMilesDrivenOnReturn = 32;
		int totalMilesRemainingToHome = totalMilesDrivenToConcert - totalMilesDrivenOnReturn;
		System.out.println(totalMilesRemainingToHome);
		
		
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int minutesSpentShovelingMorning = 90;
		int minutesSpentShovelingAfternoon = 45;
		int hoursSpentShovelingSaturday = (minutesSpentShovelingMorning + minutesSpentShovelingAfternoon) / 60;
		int minutesSpentShovelingSaturday = (minutesSpentShovelingMorning + minutesSpentShovelingAfternoon) % 60;
		System.out.println( hoursSpentShovelingSaturday + " hrs " + minutesSpentShovelingSaturday + " mins");

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int numberOfHotDogs = 6;
		float costPerHotDogInDollars = .50F;
		float costOfHotDogsTotalInDollars = numberOfHotDogs * costPerHotDogInDollars;
		System.out.println(costOfHotDogsTotalInDollars);
		

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int totalCashMrsHiltInCents = 50;
		int costPerPencilInCents = 7;
		int numberOfPencilsAfforded = totalCashMrsHiltInCents / costPerPencilInCents;
		System.out.println(numberOfPencilsAfforded);

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int numberOfButterfliesSpotted = 33;
		int numberOfOrangeButterflies = 20;
		int numberOfRedButterflies = numberOfButterfliesSpotted - numberOfOrangeButterflies;
		System.out.println(numberOfRedButterflies);
	
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double amountKatePaidInDollars = 1.00;
		double amountKateOwedInDollars = .54;
		double amountChangeToKateInDollars = amountKatePaidInDollars - amountKateOwedInDollars;
		System.out.println(amountChangeToKateInDollars);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int numberOfTreesInBackyard = 13;
		int numberOfTreesPlanted = 12;
		numberOfTreesInBackyard += numberOfTreesPlanted;
		System.out.println(numberOfTreesInBackyard);


        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int numberOfDays = 2;
		int numberOfHoursPerDay = 24;
		int numberOfHoursRemaining = numberOfDays * numberOfHoursPerDay;
		System.out.println(numberOfHoursRemaining);
	

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousins = 4;
		int piecesOfGumPerCousin = 5;
		int totalPiecesOfGum = numberOfCousins * piecesOfGumPerCousin;
		System.out.println(totalPiecesOfGum);

		
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		int amountDanHasInDollars = 3;
		int costOfCandyBarInDollars = 1;
		amountDanHasInDollars -= costOfCandyBarInDollars;
		System.out.println(amountDanHasInDollars);

		
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoats = 5;
		int numberOfPeoplePerBoat = 3;
		int numberOfPeopleTotal = numberOfBoats * numberOfPeoplePerBoat;
		System.out.println(numberOfPeopleTotal);


        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int numberOfLegosEllenHas = 380;
		int numberOfLegosLost = 57;
		numberOfLegosEllenHas -= numberOfLegosLost;
		System.out.println(numberOfLegosEllenHas);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int numberOfMuffinsNeeded = 83;
		int numberOfMuffinsFinished = 35;
		numberOfMuffinsNeeded -= numberOfMuffinsFinished;
		System.out.println(numberOfMuffinsNeeded);


        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int numberOfCrayonsForWilly = 1400;
		int numberOfCrayonsForLucy = 290;
		int differenceInNumberOfCrayons = numberOfCrayonsForWilly - numberOfCrayonsForLucy;
		System.out.println(differenceInNumberOfCrayons);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int numberOfPages = 22;
		int numberOfStickersTotal = stickersPerPage * numberOfPages;
		System.out.println(numberOfStickersTotal);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		float totalNumberOfCupcakes = 96F;
		int numberOfChildren = 8;
		float numberOfCupcakesPerChild = totalNumberOfCupcakes / numberOfChildren;
		System.out.println(numberOfCupcakesPerChild);
		
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int numberOfCookiesTotal = 47;
		int numberOfCookiesPerJar = 6;
		int numberOfCookiesLeftover = numberOfCookiesTotal % numberOfCookiesPerJar;
		System.out.println(numberOfCookiesLeftover);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int numberOfCroissantsTotal = 59;
		int numberOfNeighbors = 8;
		int numberOfCroissantsLeftover = numberOfCroissantsTotal % numberOfNeighbors;
		System.out.println(numberOfCroissantsLeftover);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int numberOfOatCookiesTotal = 276;
		int numberOfOatCookiesPerTray = 12;
		int numberOfTraysNeeded = numberOfOatCookiesTotal / numberOfOatCookiesPerTray;
		System.out.println(numberOfTraysNeeded);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int numberOfPretzelsTotal = 480;
		int numberOfPretzelsPerServing = 12;
		float numberOfServingsMade = (float)numberOfPretzelsTotal / (float)numberOfPretzelsPerServing;
		System.out.println(numberOfServingsMade);
		
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int numberOfLemonCupcakesBaked = 53;
		int numberOfLemonCupcakesLeftBehind = 2;
		int numberOfLemonCupcakesPerBox = 3;
		int numberOfBoxesGifted = (numberOfLemonCupcakesBaked - numberOfLemonCupcakesLeftBehind) / numberOfLemonCupcakesPerBox;
		System.out.println(numberOfBoxesGifted);
	
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int numberOfCarrotSticksPrepared = 74;
		int numberOfCarrotEaters = 12;
		int numberOfCarrotsLeftover = numberOfCarrotSticksPrepared % numberOfCarrotEaters;
		System.out.println(numberOfCarrotsLeftover);
	
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int numberOfTeddyBearsTotal = 98;
		int numberOfBearsPerShelf = 7;
		int numberOfFilledShelves = numberOfTeddyBearsTotal / numberOfBearsPerShelf;
		System.out.println(numberOfFilledShelves);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int numberOfPicturesTotal = 480;
		int numberOfPicturesPerAlbum = 20;
		int numberOfAlbumsNeeded = numberOfPicturesTotal / numberOfPicturesPerAlbum;
		System.out.println(numberOfAlbumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int numberOfTradingCardsTotal = 94;
		int numberOfCardsPerBox = 8;
		int numberOfFilledBoxes = numberOfTradingCardsTotal / numberOfCardsPerBox;
		int numberOfCardsInFinalBox = numberOfTradingCardsTotal % numberOfCardsPerBox;
		System.out.println(numberOfFilledBoxes + "  " + numberOfCardsInFinalBox);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int numberOfBooksTotal = 210;
		int numberOfShelves = 10;
		int numberOfBooksPerShelf = numberOfBooksTotal / numberOfShelves;
		System.out.println(numberOfBooksPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int numberOfCroissantTotal = 17;
		int numberOfGuests = 7;
		int numberOfCroissantPerGuest = numberOfCroissantTotal / numberOfGuests;
		System.out.println(numberOfCroissantPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		double squareFootageOfRoom = 12 * 14;
		double hourlyRateOfPaintingBill = squareFootageOfRoom / 2.15;
		double hourlyRateOfPaintingJill = squareFootageOfRoom / 1.90;
		double hourlyRateOfPaintingCombined = hourlyRateOfPaintingBill + hourlyRateOfPaintingJill;
		double timeToPaintFiveRooms = 5 * squareFootageOfRoom / hourlyRateOfPaintingCombined;
		System.out.println("Time to paint five rooms: " + timeToPaintFiveRooms + " hrs");
		double numberOfRooms = 623;
		double hoursInWorkday = 8;
		double daysToPaintMultipleRooms = ((numberOfRooms * squareFootageOfRoom) / hourlyRateOfPaintingCombined) / hoursInWorkday;
		System.out.println("Time to paint 623 rooms: " + daysToPaintMultipleRooms + " days");
		

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String nameFirst = "Nicholas";
		String nameMiddleInitial = "B";
		String nameLast = "Weller";
		String nameFull = nameLast + ", " + nameFirst + " " + nameMiddleInitial + ".";
		System.out.println(nameFull);

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		double distanceTotalInMiles = 800;
		double distanceTraveledInMiles = 537;
		double percentageDistanceCompleted = distanceTraveledInMiles / distanceTotalInMiles * 100;
		System.out.println("You have completed " + (int)percentageDistanceCompleted + "% of the trip.");


	}

}
