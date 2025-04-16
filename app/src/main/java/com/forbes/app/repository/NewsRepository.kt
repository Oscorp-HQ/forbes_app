package com.forbes.app.repository

import com.forbes.app.model.NewsItem
import com.forbes.app.model.NewsCategory

class NewsRepository {
    fun getBreakingNews(): List<NewsItem> = listOf(
        NewsItem(
    id = "1",
    title = "Federal Judge Blocks Trump Administration Policy",
    description = "A federal judge has issued a temporary restraining order against a controversial immigration policy.",
    imageUrl = "https://picsum.photos/400/300?random=1",
    author = "Sarah Johnson",
    date = "2025-04-14",
    content = """
        A federal judge in San Francisco has issued a temporary restraining order blocking the implementation of a controversial Trump administration policy that would have restricted asylum claims at the southern border. 
        
        Judge Maria Rodriguez cited "serious questions about the policy's legality" and potential violations of existing immigration law in her 42-page ruling issued Monday.
        
        The policy, announced last month, would have required asylum seekers to remain in Mexico for at least 90 days before being eligible to enter the United States. Administration officials had argued the measure was necessary to reduce strain on processing facilities.
        
        "The court finds that the plaintiffs have established a likelihood of success on the merits of their claims," Rodriguez wrote. "Moreover, the balance of hardships tips sharply in their favor."
        
        The restraining order will remain in effect for 14 days, during which time the court will consider arguments for a longer preliminary injunction. The Department of Justice has announced it will appeal the decision.
        
        Immigration advocates celebrated the ruling as a victory for due process. "This decision affirms that the administration cannot simply rewrite immigration law through executive action," said Carlos Mendez, attorney with the Immigration Legal Defense Fund.
        
        White House Press Secretary Mark Thompson criticized the ruling, calling it "another example of judicial overreach that undermines our national security."
    """,
    category = NewsCategory.BREAKING_NEWS
),
NewsItem(
    id = "2",
    title = "New AI Model Predicts 44 Earth-like Planets",
    description = "Scientists have discovered potential new habitable worlds using advanced algorithms.",
    imageUrl = "https://picsum.photos/400/300?random=2",
    author = "Michael Chen",
    date = "2025-04-14",
    content = """
        Using advanced machine learning algorithms, NASA scientists have identified 44 potentially Earth-like planets that previous detection methods missed.
        
        The breakthrough research, published today in the journal Astrophysical Review, utilized a new AI model called ExoFinder that was trained on data from the James Webb Space Telescope and previous exoplanet missions.
        
        "What makes this discovery particularly exciting is that these planets exist in what we call the 'habitable zone' of their respective star systems," said Dr. Elena Patel, lead researcher on the project. "These are worlds where liquid water could exist on the surface."
        
        The planets range in size from 0.8 to 1.4 times the size of Earth and orbit their stars at distances similar to Earth's orbit around the sun. Seventeen of the newly identified planets orbit red dwarf stars, while the remainder orbit stars more similar to our sun.
        
        The ExoFinder AI was able to detect subtle patterns in stellar light fluctuations that human astronomers and previous algorithms had overlooked. The model cross-referenced multiple sources of data to confirm its findings.
        
        "This represents a significant leap forward in our search for potentially habitable worlds," said Dr. James Morrison, director of NASA's Exoplanet Exploration Program. "We're now planning follow-up observations to analyze the atmospheric composition of these planets."
        
        The nearest of these newly discovered worlds is approximately 24 light-years from Earth, making it a potential candidate for future interstellar probes.
    """,
    category = NewsCategory.BREAKING_NEWS
),
NewsItem(
    id = "3",
    title = "Global Markets React to New Trade Policies",
    description = "International markets show mixed reactions to unexpected policy shifts.",
    imageUrl = "https://picsum.photos/400/300?random=3",
    author = "Emma Wilson",
    date = "2025-04-14",
    content = """
        Stock markets across Asia and Europe showed mixed reactions today following the unexpected announcement of major trade policy changes by the United States and China.
        
        The Nikkei 225 in Tokyo closed up 2.3%, while the Shanghai Composite fell 1.7%. European markets opened cautiously, with the FTSE 100 in London rising 0.6% and Germany's DAX dropping 0.4%.
        
        The policy changes, announced simultaneously by Washington and Beijing, include a reduction of tariffs on agricultural products, electronics, and automobiles, as well as new frameworks for technology transfers and intellectual property protections.
        
        "This represents the most significant shift in trade relations between the world's two largest economies in over five years," said Victoria Chang, chief global economist at Morgan Stanley. "Markets are still processing the implications."
        
        The tech sector saw particularly volatile trading, with semiconductor manufacturers experiencing gains while software companies faced pressure. The dollar strengthened against most major currencies, gaining 0.8% against the euro and 0.5% against the yen.
        
        Commodities markets also responded strongly, with copper prices jumping 3.2% on expectations of increased manufacturing activity. Oil prices remained relatively stable, with Brent crude up 0.3%.
        
        Analysts predict continued market volatility in the coming days as investors assess the long-term economic impact of the new trade landscape. "We're seeing a significant realignment of global trade patterns," said Robert Klein of Goldman Sachs. "The full effects won't be clear for several quarters."
    """,
    category = NewsCategory.BREAKING_NEWS
)
    )

    fun getLatestStories(): List<NewsItem> = listOf(
        NewsItem(
    id = "4",
    title = "Tech Giants Announce Breakthrough in Quantum Computing",
    description = "Major advancement in quantum processing promises computational leap.",
    imageUrl = "https://picsum.photos/400/300?random=4",
    author = "David Lee",
    date = "2025-04-14",
    content = """
        In a groundbreaking announcement that could revolutionize computing, a consortium of tech giants including IBM, Google, and Microsoft revealed they have achieved quantum coherence at room temperature for over 10 minutes.
        
        The achievement, announced at the International Quantum Computing Conference in Zurich, shatters previous records and represents a critical milestone in making quantum computing practical for commercial applications.
        
        "The 10-minute coherence barrier has been the Mount Everest of quantum computing," said Dr. Sophia Villanueva, quantum research director at IBM. "Maintaining quantum states typically required temperatures approaching absolute zero and could only be sustained for fractions of a second."
        
        The breakthrough came through the development of a new material called "Q-graphene," a modified form of graphene with unique quantum-stabilizing properties. The material creates what researchers call a "temporal quantum bubble" that shields qubits from environmental interference.
        
        Industry experts suggest the advancement could accelerate the timeline for practical quantum computing applications by 5-7 years. Potential impacts include revolutionary approaches to drug discovery, materials science, cryptography, and artificial intelligence.
        
        Financial markets responded immediately, with quantum computing stocks surging across major exchanges. Venture capital firms have reportedly mobilized over $3 billion in new funding for quantum startups in the 24 hours following the announcement.
        
        "This isn't just an incremental improvement—it's a paradigm shift," said Kevin Langford, technology analyst at JP Morgan. "Companies that adapt quickly to this new computing reality will have significant advantages in the coming decade."
        
        The consortium has committed to making the core technology available through open-source licensing, though commercial applications built on the platform will remain proprietary.
    """,
    category = NewsCategory.LATEST_STORIES
),
NewsItem(
    id = "5",
    title = "Climate Change Summit Reaches New Agreement",
    description = "Global leaders have reached a consensus on ambitious carbon reduction targets.",
    imageUrl = "https://picsum.photos/400/300?random=5",
    author = "Sophia Martinez",
    date = "2025-04-14",
    content = """
        After weeks of negotiations at the Madrid Climate Summit, world leaders have reached a landmark agreement that commits major economies to more aggressive carbon reduction targets than ever before.
        
        The new accord, dubbed the "Madrid Protocol," requires signatory nations to reduce carbon emissions by 65% from 2020 levels by 2035, a significant increase from previous commitments. The agreement also establishes a $300 billion annual fund to help developing nations transition to renewable energy sources.
        
        "This represents the most ambitious and concrete global climate action to date," said UN Secretary-General Antonio Rodriguez. "For the first time, we have binding commitments with specific enforcement mechanisms."
        
        A key breakthrough came when China and the United States, the world's two largest carbon emitters, agreed to joint carbon pricing mechanisms and technology sharing arrangements. The EU pledged to achieve carbon neutrality by 2040, ten years ahead of its previous target.
        
        The agreement also introduces a controversial "carbon border adjustment mechanism" that would impose tariffs on imports from countries that don't meet emission standards, a measure long advocated by European nations but previously resisted by developing economies.
        
        "We recognize the urgency of the climate crisis demands bold action," said Chinese climate envoy Li Wei. "This agreement balances environmental imperatives with economic realities."
        
        Environmental groups cautiously welcomed the agreement while noting the implementation challenges ahead. "The targets are ambitious, which is what science demands," said Greenpeace International Director Maya Patel. "The test will be translating commitments into action."
        
        The first formal review of progress under the new protocol will occur in 2027, with financial penalties for nations failing to meet interim targets.
    """,
    category = NewsCategory.LATEST_STORIES
)
    )

    fun getMagazineStories(): List<NewsItem> = listOf(
       NewsItem(
    id = "6",
    title = "The Future of Work: Remote or Office?",
    description = "Companies are rethinking their work policies as hybrid models evolve.",
    imageUrl = "https://picsum.photos/400/300?random=6",
    author = "James Wilson",
    date = "2025-04-14",
    content = """
        The debate over remote work continues to reshape corporate America five years after the pandemic first forced an unprecedented work-from-home experiment. As companies finalize their long-term workplace strategies, a new consensus appears to be emerging—but it's more nuanced than many expected.
        
        "The pendulum has swung back and forth several times," explains Dr. Melissa Chen, professor of organizational behavior at Stanford University. "First everyone was remote, then many companies mandated office returns, and now we're seeing a more sophisticated approach based on actual data about productivity and employee wellbeing."
        
        Recent research from the Workplace Futures Institute found that 62% of knowledge workers now operate in what researchers call "structured flexibility" environments—hybrid arrangements with clear guidelines about when in-person collaboration is expected versus when remote work is encouraged.
        
        Tech giant Salesforce exemplifies this evolved approach. "Monday and Friday are designated remote days across the company," says Ryan Park, Chief People Officer. "Tuesday through Thursday, teams coordinate in-office schedules based on collaboration needs, with a minimum of two days in-office each week."
        
        The data supports this balanced approach. A longitudinal study by McKinsey spanning 2020-2025 found that companies with structured hybrid policies reported 23% higher employee retention and 18% greater innovation output compared to both fully remote and fully in-office models.
        
        Real estate markets have adjusted accordingly. Major metropolitan areas have seen office vacancies stabilize around 15-20%, down from pandemic peaks but still significantly higher than pre-2020 levels. Meanwhile, demand for flexible workspace options has tripled since 2019.
        
        "The most successful companies recognize that workspace design itself needs to change," notes architect Maria Gonzalez, whose firm specializes in post-pandemic office redesigns. "When employees come to the office now, they need spaces optimized for the kinds of activities that benefit from in-person interaction—collaboration, mentorship, and social connection."
        
        As artificial intelligence increasingly automates routine tasks, the value of human creativity and collaboration has only grown. "The companies leading their industries in 2025 aren't asking 'remote or office?'" says Chen. "They're asking 'what kinds of work benefit from which environment, and how do we design systems that optimize for both?'"
    """,
    category = NewsCategory.MAGAZINE
)
    )
} 