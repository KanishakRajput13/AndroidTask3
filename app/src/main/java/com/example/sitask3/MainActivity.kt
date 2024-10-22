package com.example.sitask3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var heroArrayList : ArrayList<Hero>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myRecyclerView = findViewById(R.id.recyclerView)

        val heroImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16,

        )

        val heroNameArray = arrayOf(
            "Ant Man",
            "Black Panther",
            "Black Widow",
            "Captian America",
            "Captian Marvel",
            "Doctor Strange",
            "Groot",
            "Hawkeye",
            "Hulk",
            "Iron Man",
            "Rocket Racoon",
            "Scarlett Witch",
            "Spider Man",
            "Star Lord",
            "Thor",
            "Vision",
        )

        val heroDataArray = arrayOf(
            "Ant-Man, also known as Scott Lang, is a former thief turned superhero who wields a suit that allows him to shrink in size while increasing his strength. Originally designed by Dr. Hank Pym, the suit gives Scott the ability to control his size, enabling him to shrink to subatomic levels or grow to enormous sizes, earning him the nickname \"Giant-Man\" when enlarged. Lang took on the Ant-Man mantle to protect his daughter, Cassie, and redeem himself after a life of crime. With the help of the Pym particles, Ant-Man can communicate and control ants, using them for surveillance or as part of his fighting strategy. His comedic personality and quick thinking make him a valuable member of the Avengers. Though often underestimated, Scott has played critical roles in major events like stopping Darren Cross, battling with the Avengers in \"Civil War,\" and helping undo the Blip in \"Avengers: Endgame\" by navigating the quantum realm. His connection to the quantum realm also made him crucial in the development of time travel in the MCU.",
            "Black Panther, also known as T'Challa, is the king of the fictional African nation of Wakanda. After the death of his father, King T'Chaka, T'Challa assumes the mantle of both the monarch and the Black Panther, the protector of Wakanda. Wakanda is one of the most technologically advanced nations on Earth, thanks to its reserves of vibranium, a rare, indestructible metal. The Black Panther suit is made from vibranium and grants T'Challa enhanced strength, agility, and the ability to absorb and release kinetic energy. T'Challa is a brilliant strategist, skilled martial artist, and a compassionate leader, committed to the betterment of his people and the world. His loyalty to his country, combined with his sense of justice, leads him to open up Wakanda to the world after years of isolation. He forms alliances with other heroes, notably during the battles in \"Captain America: Civil War\" and the fight against Thanos in \"Infinity War\" and \"Endgame.\" Black Panther is a symbol of strength, wisdom, and responsibility in the MCU.",
            "Black Widow, also known as Natasha Romanoff, is a former Russian spy and assassin who later becomes an agent of S.H.I.E.L.D. and a founding member of the Avengers. Trained in the Red Room, a top-secret Soviet program, Natasha is an expert in hand-to-hand combat, espionage, and marksmanship. Her skills make her a formidable fighter and a valuable asset to the Avengers. Black Widow is known for her cunning tactics, resourcefulness, and ability to outsmart her enemies. Despite her dark past, Natasha seeks redemption and works to make amends for her previous actions. She forms close bonds with her fellow Avengers, especially Clint Barton (Hawkeye) and Steve Rogers (Captain America). Natasha plays a crucial role in many missions, including the Battle of New York, the fight against Ultron, and the battle against Thanos. Her sacrifice in \"Avengers: Endgame\" to obtain the Soul Stone showcases her bravery and selflessness, solidifying her legacy as a hero.",
            "Captain America, or Steve Rogers, is a World War II hero who was transformed into the perfect soldier through the Super Soldier Serum. Steve was a frail young man from Brooklyn, but his unyielding sense of justice and courage made him the perfect candidate for the experiment. After being transformed into Captain America, Steve fought against Hydra and the Red Skull during the war, wielding his iconic vibranium shield. After being frozen in ice for decades, Steve was revived in the present day and became the leader of the Avengers. He is known for his unwavering moral compass, sense of duty, and willingness to sacrifice himself for others. His leadership in battles against Loki, Ultron, and Thanos helped shape the MCU’s key events. In \"Avengers: Endgame,\" Steve returns the Infinity Stones to their rightful timelines and chooses to live a life of peace with Peggy Carter, passing his shield to Sam Wilson, the new Captain America.",
            "Captain Marvel, or Carol Danvers, is one of the most powerful heroes in the MCU. A former U.S. Air Force pilot, Carol gains her extraordinary abilities after being exposed to energy from the Tesseract, an Infinity Stone. Her powers include superhuman strength, flight, and the ability to project powerful photon blasts. After losing her memory and being trained by the Kree, Carol eventually regains her identity and returns to Earth to help defend it from alien threats. Her superhero persona, Captain Marvel, embodies resilience, determination, and a strong sense of justice. She plays a crucial role in defeating Thanos during the final battle in \"Avengers: Endgame.\" Carol also becomes a key figure in protecting the galaxy, often operating on a cosmic scale beyond Earth. Her abilities make her one of the strongest Avengers, and her leadership qualities solidify her role in future battles.\n",
            "Doctor Stephen Strange, also known as Doctor Strange, is a former neurosurgeon who becomes the Sorcerer Supreme, protecting Earth from mystical threats. After a car accident leaves his hands permanently damaged, Strange seeks healing in the mystic arts, which leads him to the Ancient One and Kamar-Taj. Through his training, Strange masters the use of magic, gaining the ability to manipulate time and space, and wields powerful artifacts like the Eye of Agamotto, which houses the Time Stone. As Sorcerer Supreme, Strange protects the world from interdimensional threats like Dormammu and leads the defense against Thanos in \"Avengers: Infinity War.\" Known for his intellect, resourcefulness, and a touch of arrogance, Doctor Strange’s character arc is one of redemption, transforming from a self-centered surgeon to a selfless defender of the multiverse. His involvement in the multiverse and his connection to the mystical arts makes him a central figure in upcoming MCU storylines.",
            "Groot is a sentient, tree-like creature and member of the Guardians of the Galaxy. Originally introduced as a full-grown, towering figure, Groot sacrifices himself to protect his friends during the events of the first \"Guardians of the Galaxy\" film. However, he regrows from a sapling and is reborn as Baby Groot, eventually maturing into Teenage Groot as seen in subsequent films. Though he can only say \"I am Groot,\" his close friends, especially Rocket Raccoon, can understand the nuances of his speech. Groot possesses incredible strength, the ability to extend his limbs and regenerate, and a deep loyalty to his friends. His selflessness and innocent demeanor make him a beloved character in the MCU. As a member of the Guardians, Groot helps defend the galaxy from various threats, including Ronan the Accuser, Ego the Living Planet, and Thanos.",
            "Hawkeye, or Clint Barton, is a highly skilled archer and marksman, known for his incredible accuracy and combat abilities. A former S.H.I.E.L.D. agent, Clint is one of the founding members of the Avengers, even though he does not possess superhuman abilities. Armed with his trusty bow and an array of specialized arrows, Hawkeye has proven himself in battles alongside more powerful heroes. His expertise in archery, hand-to-hand combat, and strategic thinking make him an invaluable asset to the team. In \"Avengers: Endgame,\" we see a darker side of Clint after the loss of his family during the Snap, as he takes on the identity of Ronin and wages a one-man war against criminals. However, his friendship with Natasha Romanoff and his love for his family bring him back to the Avengers to help reverse Thanos' actions. Hawkeye's grounded nature and loyalty make him a relatable and respected figure in the MCU.\n",
            "Hulk, also known as Dr. Bruce Banner, is a scientist who transforms into a massive, green, super-strong being when enraged. After being exposed to gamma radiation during an experiment gone wrong, Banner struggles to control his transformations into the Hulk, often fearing the destruction it causes. However, over time, Bruce learns to embrace his alter ego and finds ways to coexist with the Hulk. As the Hulk, Bruce possesses nearly limitless strength, durability, and regenerative abilities, making him one of the strongest beings in the MCU. Despite his brutish exterior, Hulk has a softer side, especially in his friendships with characters like Thor and Black Widow. By \"Avengers: Endgame,\" Bruce merges his intellect with the Hulk’s power, becoming Professor Hulk, a more balanced version of the character. Hulk plays a critical role in undoing the Snap by wielding the Infinity Gauntlet to bring back half of the universe’s population.",
            "Iron Man, or Tony Stark, is a billionaire genius, inventor, and philanthropist who becomes one of the founding members of the Avengers. After being captured by terrorists and forced to build a weapon of mass destruction, Tony instead creates a suit of armor to escape, marking the birth of Iron Man. Tony continuously refines his suits, equipping them with advanced technology, weapons, and AI systems. He is a brilliant strategist and innovator, responsible for creating key technologies used by the Avengers, including the development of artificial intelligence like J.A.R.V.I.S. and Friday. Despite his arrogance and self-destructive tendencies, Tony's journey is one of selflessness, culminating in his ultimate sacrifice in \"Avengers: Endgame.\" By using the Infinity Stones to defeat Thanos, Tony saves the universe but loses his life in the process. His legacy as a hero, mentor, and visionary lives on, making him one of the most iconic figures in the MCU.",
            "Rocket Raccoon is a genetically modified raccoon with enhanced intelligence, combat skills, and a sharp wit. Known for his sarcastic personality, Rocket is a skilled pilot, engineer, and weapons expert. Despite his rough exterior and tendency to push people away, Rocket is deeply loyal to his friends, especially Groot, his constant companion. Rocket is a key member of the Guardians of the Galaxy, helping to defend the universe from various threats, including Ronan the Accuser and Thanos. His resourcefulness and tactical skills often save the day, and he has a knack for escaping seemingly impossible situations. Over time, Rocket’s character arc shows his growth from a lone, bitter creature to a more compassionate and self-aware hero who cares deeply for his chosen family. His complex personality makes him both comedic relief and a deeply emotional character in the MCU.",
            "Scarlet Witch, or Wanda Maximoff, is one of the most powerful characters in the MCU. Originally introduced as a villain, Wanda has the ability to manipulate reality and wield chaos magic, which she uses to devastating effect. Her powers come from experimentation with the Mind Stone, granting her telekinetic, telepathic, and energy-manipulating abilities. Over time, Wanda evolves from an antagonist to a hero, joining the Avengers and fighting alongside them in battles against Ultron, Thanos, and more. Her emotional journey is marked by profound loss, including the death of her twin brother, Pietro, and her love, Vision. This trauma leads to her starring role in \"WandaVision,\" where she creates an alternate reality to cope with her grief. By the end of her arc in the series, Wanda fully embraces her identity as the Scarlet Witch, setting the stage for future MCU events involving magic and the multiverse.",
            "Spider-Man, also known as Peter Parker, is a teenage superhero with extraordinary abilities after being bitten by a radioactive spider. Peter gained superhuman strength, agility, and the ability to stick to walls, along with his iconic \"spidey-sense\" that alerts him to danger. Living by the motto “With great power comes great responsibility,” Peter juggles his life as a high school student and his duties as Spider-Man. In the MCU, Peter is mentored by Tony Stark, who provides him with advanced suits and technology to enhance his abilities. Peter's innocence, resourcefulness, and strong moral compass make him a beloved hero. He plays key roles in \"Civil War,\" \"Infinity War,\" and \"Endgame,\" proving himself worthy to fight alongside the Avengers. His character is defined by his struggle to protect his loved ones while embracing his role as a hero. In \"Spider-Man: No Way Home,\" Peter faces significant personal sacrifices but remains committed to doing what’s right, even at great personal cost.",
            "Star-Lord, or Peter Quill, is the charismatic leader of the Guardians of the Galaxy. Raised on Earth, Peter is abducted by space pirates known as the Ravagers and grows up in space. He adopts the Star-Lord persona, becoming a skilled pilot, thief, and outlaw. Star-Lord's charm, quick wit, and deep love for music from the '70s and '80s define his character. Equipped with his trademark blasters and a love for adventure, he eventually joins forces with other misfits to form the Guardians of the Galaxy. Star-Lord’s quest to find his father, Ego, reveals his part-celestial heritage, giving him temporary god-like powers. Despite his lighthearted demeanor, Star-Lord harbors emotional scars from his mother’s death and the betrayal by his father. His leadership is tested in battles against Ronan, Thanos, and others, but his loyalty to his team never wavers. Quill’s relationships with Gamora and the Guardians become his true family, grounding him in the fight for the galaxy’s future.",
            "Thor, the God of Thunder, is one of the most powerful characters in the MCU and a key member of the Avengers. He is the prince (and later king) of Asgard, a realm of gods, and wields the enchanted hammer Mjolnir, which grants him control over lightning and thunder. Thor is the son of Odin and the adopted brother of Loki. Initially brash and arrogant, Thor learns humility and compassion through his exile to Earth, where he teams up with humans and becomes a founding member of the Avengers. His immense strength, near invulnerability, and godlike powers make him a formidable force in battle.\n" +
                    "\n" +
                    "Throughout his journey, Thor faces personal losses, including the destruction of Asgard, the deaths of his parents, and the loss of his people. Despite these tragedies, he continues to fight for justice, eventually wielding the mighty weapon Stormbreaker. His sense of humor, loyalty, and evolving sense of duty make him a fan favorite. In \"Avengers: Endgame,\" Thor plays a crucial role in the fight against Thanos, though he struggles with self-doubt after failing to stop the Mad Titan in \"Infinity War.\" By the end of \"Endgame,\" he passes on the leadership of Asgard to Valkyrie and sets out to rediscover himself, aligning with the Guardians of the Galaxy.",
            "Vision is an android created by a combination of Tony Stark, Bruce Banner, the Mind Stone, and the vibranium body initially meant for Ultron. He is a being of immense power, possessing superhuman strength, flight, and the ability to manipulate his density, enabling him to phase through objects or become nearly indestructible. Vision’s connection to the Mind Stone grants him wisdom and empathy, making him one of the most thoughtful and philosophical characters in the MCU. His relationship with Wanda Maximoff (Scarlet Witch) grows throughout the films, and his tragic death in \"Avengers: Infinity War\" marks a turning point in Wanda’s emotional journey. Vision sacrifices himself in an attempt to prevent Thanos from acquiring the Mind Stone. Later, in \"WandaVision,\" Vision is resurrected in an alternate reality created by Wanda, where his love for her and his quest for self-awareness play central roles. Vision's blend of power and humanity makes him a unique and pivotal character.",
            )

        myRecyclerView.layoutManager = LinearLayoutManager(this)

        heroArrayList = arrayListOf()

        for (index in heroImageArray.indices){
            val hero = Hero(heroNameArray[index], heroImageArray[index], heroDataArray[index])
            heroArrayList.add(hero)
        }

        val myAdapter = MyAdapter(heroArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(applicationContext, HeroDetails::class.java)
                intent.putExtra("heroName", heroArrayList[position].heroName)
                intent.putExtra("heroImage", heroArrayList[position].heroImage)
                intent.putExtra("heroDetails", heroArrayList[position].heroDetails)
                startActivity(intent)
            }
        })

    }
}