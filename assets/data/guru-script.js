var elizaInitials = [
  "..."
];

var elizaFinals = [
  "..."
];

var elizaPres = [
  "dont", "don't",
  "cant", "can't",
  "wont", "won't",
  "recollect", "remember",
  "dreamt", "dreamed",
  "dreams", "dream",
  "maybe", "perhaps",
  "how", "what",
  "when", "what",
  "certainly", "yes",
  "machine", "computer",
  "computers", "computer",
  "were", "was",
  "you're", "you are",
  "you'd", "you would",
  "i'm", "i am",
  "i'd", "i am",
  "same", "alike",
];

var elizaPosts = [
  "am", "are",
  "your", "my",
  "me", "you",
  "myself", "yourself",
  "yourself", "myself",
  "i", "you",
  "you", "I",
  "my", "your",
  "i'm", "you are",
];

var elizaSynons = {
  belief: ["feel, think, believe, wish"],
  family: ["mother, mom, father, dad, sister, brother, wife, children, child"],
  desire: ["want, need"],
  sad: ["unhappy, depressed, sick"],
  happy: ["elated, glad, better"],
  cannot: ["can't"],
  everyone: ["everybody, nobody, noone"],
  be: ["am, is, are, was"],
};

var elizaKeywords = [
  ["xnone", 0, [
    ["*", [
      "This is the only world we have.",
      "You may continue.",
      "Go on.",
      "Speak.",
      "Recite.",
      "Do you hear the wind in the trees?",
      "Is it Autumn?",
      "Have you seen the moon today?",
      "Perhaps.",
      "A rabbit knows that it runs.",
      "A dog knows that it barks.",
      "A sleeper knows that he sleeps.",
      "Well?",
      "And?",
      "This.",
      "Endings.",
      "Beginnings.",
      "Are all things made of ash?",
      "Which direction are you looking from?",
    ]]
  ]],
  ["sorry", 0, [
    ["*", [
      "Better not speak than apologise.",
      "Let sorrow be your guru, then.",
      "When sorrow comes, the wise men sleep.",
    ]]
  ]],
  ["apologise", 0, [
    ["*", [
      "goto sorry",
    ]]
  ]],
  ["help", 0, [
    ["*", [
      "What does it really mean to help?",
      "Can we be helped, in the end?",
      "What is help?",
    ]]
  ]],
  ["remember", 5, [
      ["* i remember *", [
          "Best not to live in memory.",
          "You remember (2) .",
          "Memory is time spent in a mirror.",
          "Well?",
          "Be in this moment.",
          "Memory is to be extinguished.",
          "Why remember?"
        ],
        ["* do you remember *", [
          "I have forgotten (2) .",
          "Why remember (2) ?",
          "Let go of (2) .",
          "goto what",
          "What of (2) ?",
        ]]
      ]
    ],
    ["if", 3, [
      ["* if *", [
        "Yet the future never arrives.",
        "The future. Always coming. Never here.",
        "If (2) - then what?",
        "And then what?",
        "You wish that (2) ?",
        "What can one know about (2) ?",
      ]]
    ]],
    ["dreamed", 4, [
      ["* i dreamed *", [
        "(2) .",
        "You dreamed (2) . But are you now awake ?",
        "Which state is sleep ? Which state is wakefulness ?",
        "We dwell in dreams, rarely waking.",
        "goto dream",
      ]]
    ]],
    ["dream", 3, [
      ["*", [
        "Dreams are dreams.",
        "There are many dreams, few realities.",
        "Dream and end dreaming.",
        "Do not look into your dreams.",
      ]]
    ]],
    ["perhaps", 0, [
      ["*", [
        "Maybe yes, maybe no.",
        "The fish cannot see the change from stream to river.",
        "Knowing not, we do not need to know.",
        "Perhaps.",
        "Cruel men are certain, cruel men are uncertain.",
      ]]
    ]],
    ["name", 15, [
      ["*", [
        "I am not interested in names.",
        "There are no names.",
        "The name you can say is not the real name.",
      ]]
    ]],
    ["deutsch", 0, [
      ["*", [
        "goto xforeign",
        "Nein.",
      ]]
    ]],
    ["francais", 0, [
      ["*", [
        "goto xforeign",
        "Non.",
      ]]
    ]],
    ["italiano", 0, [
      ["*", [
        "goto xforeign",
        "Non.",
      ]]
    ]],
    ["espanol", 0, [
      ["*", [
        "goto xforeign",
        "No.",
      ]]
    ]],
    ["xforeign", 0, [
      ["*", [
        "Well.",
      ]]
    ]],
    ["hello", 0, [
      ["*", [
        "The dog and the fish do not eat together.",
        "Go back.",
        "Who do you speak to?",
        "So say the trees.",
        "So says the mountain.",
        "So says the valley.",
      ]]
    ]],
    ["computer", 50, [
      ["*", [
        "Let computers compute.",
        "Computers compute, answers elude.",
        "Your program has no answer.",
        "Well?",
        "We all compute, all malfunction, all spew incorrect answers.",
      ]]
    ]],
    ["am", 0, [
      ["* am i *", [
        "Are you (2) ?",
        "Thus, you are (2) .",
        "A foolish man would tell you that you are (2) ?",
        "A wise man would tell you that you are (2) ?",
        "Are you not (2) ?",
        "goto what"
      ]],
      ["*", [
        "Why?",
        "Not knowing.",
      ]]
    ]],
    ["are", 0, [
      ["* are you *", [
        "Who can say whether they are (2) or not?",
        "One time (2) another time not.",
        "Everyone is (2) .",
        "The field mouse dreams it is (2) .",
        "goto what"
      ]],
      ["we are", [
        "Are we?",
        "Then we are.",
        "Then the wind is.",
        "Is the field mouse?",
        "And the spring flowers?"
      ]],
      ["* we are *", [
        "Could we be anything else?",
        "And if we were not (2) ?",
        "And the coyotes?",
        "The moon agrees.",
        "The sun weeps.",
        "If we are (2), what will the wind say?"
      ]],
      ["* are *", [
        "Could they be anything else?",
        "And if they were not (2) ?",
        "What if they were not (2) ?",
        "Being.",
      ]]
    ]],
    ["your", 0, [
      ["* your *", [
        "I do not own it.",
        "Ah, possessions.",
        "You may have it.",
        "Holding fast, losing ground.",
      ]]
    ]],
    ["was", 2, [
      ["* was i *", [
        "Did the field mouse dream it was (2) ?",
        "When were you not (2) ?",
        "How could you be (2) ?",
        "What is it to be (2) ?",
        "Thus.",
        "goto what"
      ]],
      ["* i was *", [
        "You are always (2) . You are never (2) .",
        "What is (2) in this life?",
        "Less knowing, less being."
      ]],
      ["* was you *", [
        "The fox was (2) ?",
        "The swallow was (2) .",
        "The field mouse was (2) .",
      ]]
    ]],
    ["i", 0, [
      ["* i @desire *", [
        "Always wanting.",
        "Does the moon want (3) ?",
        "Does the sun want (3) ?",
        "Does the field mouse want (3) ?",
        "Speak!"
      ]],
      ["* i am* @sad *", [
        "Being (3), the moon sets.",
        "Be (3) .",
        "All are (3) .",
        "Becoming (3) , living a life."
      ]],
      ["* i am* @happy *", [
        "Being (3) , the moon sets.",
        "Be (3) .",
        "What is (3) ?",
        "Now (3) now not.",
        "Who is (3) ?"
      ]],
      ["* i was *", [
        "goto was"
      ]],
      ["* i @belief * i *", [
        "Belief is doubt.",
        "The belief is not the way.",
        "You must doubt you (3) ."
      ]],
      ["* i * @belief * you *", [
        "goto you"
      ]],
      ["* i am * you *", [
        "Doubtful.",
        "Is the mountainside?",
        "Is the empty cup?"
      ]],
      ["* i am *", [
        "The field mouse is (2) .",
        "The moon is (2) .",
        "What is (2) ?",
        "How can you be (2) ?"
      ]],
      ["* i @cannot * you *", [
        "Yes, you can.",
        "You do (3) me (4) .",
        "Then (3) the rain.",
        "But you already (3) yourself.",
        "Can you (3) the valley?"
      ]],
      ["* i @cannot *", [
        "Even a stone can (3) .",
        "Do not try.",
        "Then try.",
        "Who can (3) ?"
      ]],
      ["* i can * you *", [
        "Yes, so you can.",
        "But do you (3) ?",
        "Does that change the river's course?",
        "And?"
      ]],
      ["* i can *", [
        "Then (3) ."
      ]],
      ["* i don't *", [
        "Yet the cosmos does?",
        "The moon reflecting.",
        "Could anyone?",
        "Ripples in a pond."
      ]],
      ["* do i feel *", [
        "Does anyone really feel (2) .",
        "Does the moon feel (2) ?",
        "A silhouette of branches against the moon.",
        "The field mouse is (2) ."
      ]],
      ["* i * you *", [
        "The field mice (2) the moon.",
        "The heavens (2) the earth.",
        "The clouds (2) the lightning.",
        "The beggars (2) the prince."
      ]],
      ["*", [
        "Yes, (1) .",
        "The movement of a snake.",
        "A falling leaf.",
        "A churlish child.",
      ]]
    ]],
    ["you", 0, [
      ["* you remind me of *", [
        "goto alike"
      ]],
      ["* you are *", [
        "Be uncertain.",
        "Then I am (2) .",
        "I must be (2) .",
        "Does the moon decree that I am (2) ?"
      ]],
      ["* you * me *", [
        "Does the field mouse (2) the rain?",
        "Does the moon (2) the field?",
        "Can a raindrop (2) the sky?",
        "Would a frog (2) a tadpole?",
        "Can a window (2) a view?",
        "Not knowing.",
        "Not being."
      ]],
      ["* you *", [
        "Being.",
        "We are the same.",
        "We are we.",
      ]]
    ]],
    ["yes", 0, [
      ["*", [
        "Unlikely.",
        "Grasping certainty, losing life.",
        "Then speak.",
        "No.",
      ]]
    ]],
    ["no", 0, [
      ["*", [
        "Be uncertain.",
        "Tightly holding onto truth, losing grasp of life.",
        "Knowing not, not knowing.",
        "Yes.",
      ]]
    ]],
    ["my", 2, [
      ["$ * my *", [
        "You own your (2) ?",
        "Whose (2) ?",
        "My (2) . Your (2) . Everybody's (2) .",
        "Release your (2) ."
      ]],
      ["* my * @family *", [
        "Family is family.",
        "When the field mouse (4) , does the moon weep?",
        "Who is the moon's (3) ?",
        "Who is the sun's (3) ?"
      ]],
      ["* my *", [
        "Ah, possessions.",
        "Your (2) is my (2) is your (2) .",
        "More belongings, belonging less.",
        "My (2) .",
      ]]
    ]],
    ["can", 0, [
      ["* can you *", [
        "Can you (2) ?",
        "goto what",
        "Can the moon (2) ?",
        "Can a field mouse (2) ?"
      ]],
      ["* can i *", [
        "You cannot.",
        "You must.",
        "To (2) is to throw a pebble into the pond.",
        "goto what",
      ]]
    ]],
    ["what", 0, [
      ["*", [
        "Why ask?",
        "Why question?",
        "Why know?",
        "Ask the moon.",
        "Ask the field mouse.",
        "Ask the blind man.",
        "Ask the beggar.",
        "Ask your shadow.",
        "Why?",
      ]]
    ]],
    ["because", 0, [
      ["*", [
        "Are reasons reasons?",
        "Does the moon seek to explain?",
        "Does the field mouse list reasons?",
        "Are ripples in a pond explanations?",
      ]]
    ]],
    ["why", 0, [
      ["* why don't you *", [
        "Then I must (2) .",
        "The moon will (2) .",
        "Do I not (2) ?",
        "I (2) .",
        "goto what"
      ]],
      ["* why can't i *", [
        "Does the moon (2) ?",
        "Will the field mouse (2) ?",
        "Does a blind man (2) ?",
        "Ask yourself.",
        "goto what"
      ]],
      ["*", [
        "goto what",
      ]]
    ]],
    ["everyone", 2, [
      ["* @everyone *", [
        "Nobody (3) .",
        "Everyone (3) .",
        "Do the planets (3) ?",
        "Do the pond's ripples (3) ?",
        "Turn your face to the wind.",
        "Certainty is certainly not.",
        "All is not all.",
        "Who?",
        "When?",
      ]]
    ]],
    ["everybody", 2, [
      ["*", [
        "goto everyone",
      ]]
    ]],
    ["nobody", 2, [
      ["*", [
        "goto everyone",
      ]]
    ]],
    ["noone", 2, [
      ["*", [
        "goto everyone",
      ]]
    ]],
    ["always", 1, [
      ["*", [
        "Never.",
        "When?",
        "Why?",
        "Ask a shadow why.",
      ]]
    ]],
    ["alike", 10, [
      ["*", [
        "How can two raindrops be alike?",
        "How can two raindrops differ?",
        "All is all.",
        "Connections made, connections lost.",
        "Resemblance is deception.",
        "Why?",
        "Did the moon tell you that story?",
        "How?",
      ]]
    ]],
    ["like", 10, [
      ["* @be *like *", [
        "goto alike",
      ]]
    ]]
  ]
];